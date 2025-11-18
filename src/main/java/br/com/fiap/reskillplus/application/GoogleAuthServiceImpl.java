package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.application.exceptions.AuthException;
import br.com.fiap.reskillplus.domain.model.AuthUsuario;
import br.com.fiap.reskillplus.domain.repository.AuthRepository;
import br.com.fiap.reskillplus.domain.service.GoogleAuthService;
import br.com.fiap.reskillplus.dto.input.AuthInputDTO;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class GoogleAuthServiceImpl implements GoogleAuthService {

    private final AuthRepository authRepository;
    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;
    private final String tokenUrl;
    private final String userUrl;

    public GoogleAuthServiceImpl(
            AuthRepository authRepository,
            @ConfigProperty(name = "google.client-id") String clientId,
            @ConfigProperty(name = "google.client-secret") String clientSecret,
            @ConfigProperty(name = "google.redirect-uri") String redirectUri,
            @ConfigProperty(name = "google.token-url") String tokenUrl,
            @ConfigProperty(name = "google.user-url") String userUrl
    ) {
        this.authRepository = authRepository;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.tokenUrl = tokenUrl;
        this.userUrl = userUrl;
    }

    @Override
    public String gerarUrlLogin() {

        String scope = URLEncoder.encode("openid email profile", StandardCharsets.UTF_8);
        String redirect = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);

        return "https://accounts.google.com/o/oauth2/v2/auth" +
                "?client_id=" + clientId +
                "&redirect_uri=" + redirect +
                "&response_type=code" +
                "&scope=" + scope;
    }

    @Override
    public AuthUsuario autenticar(AuthInputDTO input) {

        if (input.getCode() == null || input.getCode().isBlank()) {
            throw new AuthException("Código OAuth inválido");
        }

        try {
            String accessToken = trocarCodePorToken(input.getCode(), input.getRedirectUri());
            AuthUsuario usuario = buscarDadosGoogle(accessToken);

            AuthUsuario existente =
                    authRepository.buscarPorProviderId("google", usuario.getProviderId());

            if (existente != null) {
                return existente;
            }

            return authRepository.salvar(usuario);

        } catch (Exception e) {
            throw new AuthException("Falha na autenticação Google: " + e.getMessage());
        }
    }

    private String trocarCodePorToken(String code, String redirectUri) throws Exception {

        URL url = new URL(tokenUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String body =
                "code=" + code +
                        "&client_id=" + clientId +
                        "&client_secret=" + clientSecret +
                        "&redirect_uri=" + redirectUri +
                        "&grant_type=authorization_code";

        try (OutputStream os = conn.getOutputStream()) {
            os.write(body.getBytes(StandardCharsets.UTF_8));
        }

        InputStream resposta = conn.getInputStream();
        JsonObject json = Json.createReader(resposta).readObject();

        return json.getString("access_token");
    }

    private AuthUsuario buscarDadosGoogle(String accessToken) throws Exception {

        URL url = new URL(userUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
        conn.setRequestProperty("Accept", "application/json");

        InputStream resposta = conn.getInputStream();
        JsonObject json = Json.createReader(resposta).readObject();

        String id = json.getString("sub");
        String nome = json.getString("name", "");
        String email = json.getString("email", "");
        String avatar = json.getString("picture", null);

        return new AuthUsuario(
                "google",
                id,
                nome,
                email,
                avatar,
                accessToken
        );
    }
}

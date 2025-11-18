package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.application.exceptions.AuthException;
import br.com.fiap.reskillplus.domain.model.AuthUsuario;
import br.com.fiap.reskillplus.domain.repository.AuthRepository;
import br.com.fiap.reskillplus.domain.service.AuthService;
import br.com.fiap.reskillplus.dto.input.AuthInputDTO;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;
    private final String tokenUrl;
    private final String userUrl;

    public AuthServiceImpl(
            AuthRepository authRepository,
            @ConfigProperty(name = "github.client-id") String clientId,
            @ConfigProperty(name = "github.client-secret") String clientSecret,
            @ConfigProperty(name = "github.redirect-uri") String redirectUri,
            @ConfigProperty(name = "github.token-url") String tokenUrl,
            @ConfigProperty(name = "github.user-url") String userUrl
    ) {
        this.authRepository = authRepository;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.tokenUrl = tokenUrl;
        this.userUrl = userUrl;
    }

    @Override
    public String gerarUrlLoginGithub() {
        String redirect = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);
        return "https://github.com/login/oauth/authorize" +
                "?client_id=" + clientId +
                "&redirect_uri=" + redirect +
                "&scope=user:email";
    }

    @Override
    public AuthUsuario autenticarGitHub(AuthInputDTO input) {
        if (input.getCode() == null || input.getCode().isBlank()) {
            throw new AuthException("Código OAuth inválido");
        }

        try {
            String accessToken = trocarCodePorAccessToken(input.getCode(), input.getRedirectUri());
            AuthUsuario usuarioGitHub = buscarDadosGitHub(accessToken);

            AuthUsuario existente = authRepository.buscarPorProviderId(
                    usuarioGitHub.getProvider(),
                    usuarioGitHub.getProviderId()
            );

            if (existente != null) {
                return existente;
            }

            return authRepository.salvar(usuarioGitHub);

        } catch (Exception e) {
            throw new AuthException("Falha na autenticação GitHub: " + e.getMessage());
        }
    }

    private String trocarCodePorAccessToken(String code, String redirectUri) throws Exception {

        URL url = new URL(tokenUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept", "application/json");

        String body =
                "client_id=" + clientId +
                        "&client_secret=" + clientSecret +
                        "&code=" + code +
                        "&redirect_uri=" + redirectUri;

        try (OutputStream os = conn.getOutputStream()) {
            os.write(body.getBytes(StandardCharsets.UTF_8));
        }

        InputStream resposta = conn.getInputStream();
        JsonObject json = Json.createReader(resposta).readObject();

        if (!json.containsKey("access_token")) {
            throw new AuthException("GitHub não retornou access_token");
        }

        return json.getString("access_token");
    }

    private AuthUsuario buscarDadosGitHub(String accessToken) throws Exception {

        URL url = new URL(userUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
        conn.setRequestProperty("Accept", "application/json");

        InputStream resposta = conn.getInputStream();
        JsonObject json = Json.createReader(resposta).readObject();

        String id = json.getJsonNumber("id").toString();
        String nome = json.getString("name", json.getString("login"));
        String email = json.getString("email", "");

        if (email == null || email.isBlank()) {
            email = buscarEmailGithub(accessToken);
        }

        String avatar = json.containsKey("avatar_url") ? json.getString("avatar_url") : null;

        return new AuthUsuario(
                "github",
                id,
                nome,
                email,
                avatar,
                accessToken
        );
    }

    private String buscarEmailGithub(String accessToken) throws Exception {

        URL url = new URL("https://api.github.com/user/emails");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
        conn.setRequestProperty("Accept", "application/json");

        InputStream resposta = conn.getInputStream();
        JsonArray json = Json.createReader(resposta).readArray();

        for (var item : json) {
            JsonObject obj = item.asJsonObject();
            boolean primary = obj.getBoolean("primary", false);
            boolean verified = obj.getBoolean("verified", false);

            if (primary && verified) {
                return obj.getString("email");
            }
        }

        if (!json.isEmpty()) {
            return json.getJsonObject(0).getString("email");
        }

        return "";
    }
}

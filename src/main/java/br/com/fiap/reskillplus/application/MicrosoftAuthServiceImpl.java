package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.application.exceptions.AuthException;
import br.com.fiap.reskillplus.domain.model.AuthUsuario;
import br.com.fiap.reskillplus.domain.repository.AuthRepository;
import br.com.fiap.reskillplus.domain.service.MicrosoftAuthService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
public class MicrosoftAuthServiceImpl implements MicrosoftAuthService {

    private final AuthRepository authRepository;
    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;
    private final String scope;
    private final String authUrl;
    private final String tokenUrl;
    private final String userUrl;

    @Inject
    public MicrosoftAuthServiceImpl(
            AuthRepository authRepository,
            @ConfigProperty(name = "microsoft.client-id") String clientId,
            @ConfigProperty(name = "microsoft.client-secret") String clientSecret,
            @ConfigProperty(name = "microsoft.redirect-uri") String redirectUri,
            @ConfigProperty(name = "microsoft.scope") String scope,
            @ConfigProperty(name = "microsoft.auth-url") String authUrl,
            @ConfigProperty(name = "microsoft.token-url") String tokenUrl,
            @ConfigProperty(name = "microsoft.user-url") String userUrl
    ) {
        this.authRepository = authRepository;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.scope = scope;
        this.authUrl = authUrl;
        this.tokenUrl = tokenUrl;
        this.userUrl = userUrl;
    }

    @Override
    public String gerarUrlLogin() {
        String encodedRedirect = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);
        String encodedScope = URLEncoder.encode(scope, StandardCharsets.UTF_8);

        return authUrl +
                "?client_id=" + clientId +
                "&response_type=code" +
                "&redirect_uri=" + encodedRedirect +
                "&response_mode=query" +
                "&scope=" + encodedScope;
    }

    @Override
    public AuthUsuario autenticar(String code, String ignored) {
        try {
            String accessToken = trocarCodigoPorToken(code);
            AuthUsuario usuario = buscarDadosMicrosoft(accessToken);

            AuthUsuario existente =
                    authRepository.buscarPorProviderId("microsoft", usuario.getProviderId());

            if (existente != null) {
                existente.setAccessToken(usuario.getAccessToken());
                existente.setNome(usuario.getNome());
                existente.setEmail(usuario.getEmail());
                existente.setAvatarUrl(usuario.getAvatarUrl());
                return existente;
            }

            return authRepository.salvar(usuario);

        } catch (Exception e) {
            throw new AuthException("Falha na autenticação Microsoft: " + e.getMessage());
        }
    }

    private String trocarCodigoPorToken(String code) throws Exception {

        URL url = new URL(tokenUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String body =
                "client_id=" + clientId +
                        "&scope=" + URLEncoder.encode(scope, StandardCharsets.UTF_8) +
                        "&code=" + code +
                        "&redirect_uri=" + URLEncoder.encode(redirectUri, StandardCharsets.UTF_8) +
                        "&grant_type=authorization_code" +
                        "&client_secret=" + URLEncoder.encode(clientSecret, StandardCharsets.UTF_8);

        try (OutputStream os = conn.getOutputStream()) {
            os.write(body.getBytes(StandardCharsets.UTF_8));
        }

        if (conn.getResponseCode() != 200) {
            InputStream err = conn.getErrorStream();
            String erro = new String(err.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println("====== MICROSOFT TOKEN ERROR ======");
            System.out.println(erro);
            System.out.println("===================================");
            throw new RuntimeException("Erro ao solicitar token do Microsoft");
        }

        JsonObject json = Json.createReader(conn.getInputStream()).readObject();
        return json.getString("access_token");
    }

    private AuthUsuario buscarDadosMicrosoft(String accessToken) throws Exception {
        URL url = new URL(userUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization", "Bearer " + accessToken);

        JsonObject json = Json.createReader(conn.getInputStream()).readObject();

        return new AuthUsuario(
                "microsoft",
                json.getString("id"),
                json.getString("displayName", ""),
                json.containsKey("mail") && !json.isNull("mail")
                        ? json.getString("mail")
                        : json.getString("userPrincipalName", ""),
                null,
                accessToken
        );
    }
}

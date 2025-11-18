package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.application.AuthServiceImpl;
import br.com.fiap.reskillplus.domain.repository.AuthRepository;
import br.com.fiap.reskillplus.domain.service.AuthService;

import jakarta.enterprise.context.RequestScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

public class AuthServiceConfig {

    private final AuthRepository authRepository;

    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;
    private final String tokenUrl;
    private final String userUrl;

    public AuthServiceConfig(
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

    @RequestScoped
    public AuthService authService() {
        return new AuthServiceImpl(
                authRepository,
                clientId,
                clientSecret,
                redirectUri,
                tokenUrl,
                userUrl
        );
    }
}

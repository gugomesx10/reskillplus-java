package br.com.fiap.reskillplus.infrastructure.security;

import br.com.fiap.reskillplus.application.service.ApiKeyValidator;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ApiKeyValidatorImpl implements ApiKeyValidator {

    @ConfigProperty(name = "api.key")
    String validApiKey;

    @Override
    public boolean isValid(String apiKey) {
        return apiKey != null && apiKey.equals(validApiKey);
    }

    @Override
    public boolean isPresent(String apiKey) {
        return apiKey != null && !apiKey.isBlank();
    }
}

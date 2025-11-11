package br.com.fiap.reskillplus.infrastructure.security;

import br.com.fiap.reskillplus.application.exceptions.CredencialException;
import br.com.fiap.reskillplus.application.service.ApiKeyValidator;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class ApiKeyFilter implements ContainerRequestFilter {

    @Inject
    ApiKeyValidator apiKeyValidator;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String apiKey = requestContext.getHeaderString("x-api-key");

        if (apiKey == null || !apiKeyValidator.isValid(apiKey)) {
            requestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity("Acesso não autorizado: chave de API inválida ou ausente.")
                            .build()
            );
            throw new CredencialException("Chave de API inválida ou ausente.");
        }
    }
}

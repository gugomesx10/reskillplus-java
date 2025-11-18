package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.AuthInputDTO;
import br.com.fiap.reskillplus.dto.output.AuthOutputDTO;
import br.com.fiap.reskillplus.interfaces.MicrosoftAuthController;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth/microsoft")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MicrosoftAuthRestController {

    @Inject
    MicrosoftAuthController controller;

    @GET
    @Path("/login")
    public Response login() {
        String url = controller.gerarUrlLogin();
        return Response.status(Response.Status.FOUND)
                .header("Location", url)
                .build();
    }

    @GET
    @Path("/callback")
    public Response callback(
            @QueryParam("code") String code
    ) {
        if (code == null || code.isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Código não informado.")
                    .build();
        }

        AuthInputDTO dto = new AuthInputDTO();
        dto.setCode(code);
        dto.setRedirectUri("http://localhost:8080/auth/microsoft/callback");

        return Response.ok(controller.autenticar(dto)).build();
    }

    @POST
    public Response autenticar(AuthInputDTO dto) {
        return Response.ok(controller.autenticar(dto)).build();
    }
}

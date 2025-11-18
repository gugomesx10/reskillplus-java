package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.AuthInputDTO;
import br.com.fiap.reskillplus.dto.output.AuthOutputDTO;
import br.com.fiap.reskillplus.interfaces.GoogleAuthController;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth/google")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GoogleAuthRestController {

    private final GoogleAuthController controller;

    @Inject
    public GoogleAuthRestController(GoogleAuthController controller) {
        this.controller = controller;
    }

    @GET
    @Path("/login")
    public Response login() {
        return Response.status(Response.Status.FOUND)
                .header("Location", controller.gerarUrlLogin())
                .build();
    }

    @POST
    public Response autenticar(AuthInputDTO dto) {
        AuthOutputDTO out = controller.autenticar(dto);
        return Response.ok(out).build();
    }
}

package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.AuthInputDTO;
import br.com.fiap.reskillplus.dto.output.AuthOutputDTO;
import br.com.fiap.reskillplus.interfaces.AuthController;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth/github")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthRestController {

    private final AuthController authController;

    @Inject
    public AuthRestController(AuthController authController) {
        this.authController = authController;
    }

    @GET
    @Path("/login")
    public Response login() {
        String url = authController.gerarUrlLoginGithub();
        return Response.status(Response.Status.FOUND)
                .header("Location", url)
                .build();
    }

    @GET
    @Path("/callback")
    public Response callback(@QueryParam("code") String code) {
        System.out.println("CODE: " + code);
        return Response.ok("Code received: " + code).build();
    }

    @POST
    public Response autenticar(AuthInputDTO dto) {
        try {
            AuthOutputDTO out = authController.autenticar(dto);
            return Response.ok(out).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }
}

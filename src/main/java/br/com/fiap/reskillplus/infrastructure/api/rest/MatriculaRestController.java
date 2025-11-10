package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.domain.service.MatriculaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/matriculas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MatriculaRestController {

    @Inject
    MatriculaService matriculaService;

    @POST
    public Response matricular(Matricula matricula) {
        matriculaService.matricular(matricula);
        return Response.status(Response.Status.CREATED).entity(matricula).build();
    }

    @GET
    @Path("/usuario/{usuarioId}")
    public List<Matricula> listarPorUsuario(@PathParam("usuarioId") Long usuarioId) {
        return matriculaService.listarPorUsuario(usuarioId);
    }

    @PATCH
    @Path("/{id}/progresso/{valor}")
    public Response atualizarProgresso(@PathParam("id") Long id, @PathParam("valor") Integer progresso) {
        matriculaService.atualizarProgresso(id, progresso);
        return Response.ok().build();
    }
}

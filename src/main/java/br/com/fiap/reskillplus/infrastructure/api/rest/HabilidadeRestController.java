package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.domain.service.HabilidadeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/habilidades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HabilidadeRestController {

    @Inject
    HabilidadeService habilidadeService;

    @POST
    public Response adicionar(Habilidade habilidade) {
        habilidadeService.adicionar(habilidade);
        return Response.status(Response.Status.CREATED).entity(habilidade).build();
    }

    @GET
    @Path("/usuario/{usuarioId}")
    public List<Habilidade> listarPorUsuario(@PathParam("usuarioId") Long usuarioId) {
        return habilidadeService.listarPorUsuario(usuarioId);
    }

    @DELETE
    @Path("/{id}")
    public Response remover(@PathParam("id") Long id) {
        habilidadeService.remover(id);
        return Response.noContent().build();
    }
}

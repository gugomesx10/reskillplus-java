package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.domain.service.RecomendacaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/recomendacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecomendacaoRestController {

    @Inject
    RecomendacaoService recomendacaoService;

    @POST
    public Response gerar(Recomendacao recomendacao) {
        recomendacaoService.gerar(recomendacao);
        return Response.status(Response.Status.CREATED).entity(recomendacao).build();
    }

    @GET
    @Path("/usuario/{usuarioId}")
    public List<Recomendacao> listarPorUsuario(@PathParam("usuarioId") Long usuarioId) {
        return recomendacaoService.listarPorUsuario(usuarioId);
    }
}

package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.RecomendacaoInputDTO;
import br.com.fiap.reskillplus.dto.output.RecomendacaoOutputDTO;
import br.com.fiap.reskillplus.interfaces.RecomendacaoController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/recomendacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecomendacaoRestController {

    private final RecomendacaoController recomendacaoController;

    public RecomendacaoRestController(RecomendacaoController recomendacaoController) {
        this.recomendacaoController = recomendacaoController;
    }

    @POST
    public Response gerar(RecomendacaoInputDTO dto) {
        try {
            RecomendacaoOutputDTO saida = recomendacaoController.gerar(dto);
            return Response.status(Response.Status.CREATED).entity(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("erro", e.getMessage()))
                    .build();
        }
    }

    @GET
    public Response listarTodas() {
        List<RecomendacaoOutputDTO> recomendacoes = recomendacaoController.listarTodas();
        return Response.ok(recomendacoes).build();
    }

    @GET
    @Path("/usuario/{usuarioId}")
    public Response listarPorUsuario(@PathParam("usuarioId") int usuarioId) {
        List<RecomendacaoOutputDTO> recomendacoes = recomendacaoController.listarPorUsuario(usuarioId);
        return Response.ok(recomendacoes).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") int id) {
        recomendacaoController.deletar(id);
        return Response.noContent().build();
    }
}

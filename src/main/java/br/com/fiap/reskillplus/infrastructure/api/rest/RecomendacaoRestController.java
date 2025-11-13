package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.RecomendacaoInputDTO;
import br.com.fiap.reskillplus.dto.output.RecomendacaoOutputDTO;
import br.com.fiap.reskillplus.mapper.RecomendacaoMapper;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.interfaces.RecomendacaoController;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/recomendacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecomendacaoRestController {

    private final RecomendacaoController recomendacaoController;
    private final RecomendacaoMapper recomendacaoMapper;

    @Inject
    public RecomendacaoRestController(RecomendacaoController recomendacaoController,
                                      RecomendacaoMapper recomendacaoMapper) {
        this.recomendacaoController = recomendacaoController;
        this.recomendacaoMapper = recomendacaoMapper;
    }

    @POST
    public Response criarRecomendacao(RecomendacaoInputDTO dto) {
        try {
            Recomendacao rec = recomendacaoMapper.toModel(dto);
            Recomendacao criada = recomendacaoController.criarRecomendacao(rec);
            RecomendacaoOutputDTO output = recomendacaoMapper.toOutputDTO(criada);

            return Response.status(Response.Status.CREATED).entity(output).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/buscar/{cpf}/{curso}")
    public Response buscarRecomendacao(@PathParam("cpf") String cpf,
                                       @PathParam("curso") String curso) {
        try {
            Recomendacao rec = recomendacaoController.buscarRecomendacao(cpf, curso);
            RecomendacaoOutputDTO output = recomendacaoMapper.toOutputDTO(rec);
            return Response.ok(output).build();
        } catch (RuntimeException | EntidadeNaoLocalizada e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/excluir/{cpf}/{curso}")
    public Response excluirRecomendacao(@PathParam("cpf") String cpf,
                                        @PathParam("curso") String curso) {
        try {
            recomendacaoController.excluirRecomendacao(cpf, curso);
            return Response.noContent().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}

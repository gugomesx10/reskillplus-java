package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.HabilidadeInputDTO;
import br.com.fiap.reskillplus.dto.output.HabilidadeOutputDTO;
import br.com.fiap.reskillplus.mapper.HabilidadeMapper;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.interfaces.HabilidadeController;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/habilidade")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HabilidadeRestController {

    private final HabilidadeController habilidadeController;
    private final HabilidadeMapper habilidadeMapper;

    @Inject
    public HabilidadeRestController(HabilidadeController habilidadeController,
                                    HabilidadeMapper habilidadeMapper) {
        this.habilidadeController = habilidadeController;
        this.habilidadeMapper = habilidadeMapper;
    }

    @POST
    public Response criarHabilidade(HabilidadeInputDTO dto) {
        try {
            Habilidade hab = habilidadeMapper.toModel(dto);
            Habilidade criada = habilidadeController.criarHabilidade(hab);
            HabilidadeOutputDTO output = habilidadeMapper.toOutputDTO(criada);

            return Response.status(Response.Status.CREATED).entity(output).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    public Response editarHabilidade(HabilidadeInputDTO dto) {
        try {
            Habilidade hab = habilidadeMapper.toModel(dto);
            habilidadeController.editarHabilidade(hab);
            return Response.accepted().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/buscar/{nome}")
    public Response buscarHabilidade(@PathParam("nome") String nome) {
        try {
            Habilidade habilidade = habilidadeController.buscarHabilidade(nome);
            HabilidadeOutputDTO output = habilidadeMapper.toOutputDTO(habilidade);
            return Response.ok(output).build();
        } catch (RuntimeException | EntidadeNaoLocalizada e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/excluir/{nome}")
    public Response excluirHabilidade(@PathParam("nome") String nome) {
        try {
            habilidadeController.excluirHabilidade(nome);
            return Response.noContent().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}

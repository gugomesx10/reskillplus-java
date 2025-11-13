package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.CursoInputDTO;
import br.com.fiap.reskillplus.dto.output.CursoOutputDTO;
import br.com.fiap.reskillplus.mapper.CursoMapper;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.interfaces.CursoController;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/curso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoRestController {

    private final CursoController cursoController;
    private final CursoMapper cursoMapper;

    @Inject
    public CursoRestController(CursoController cursoController, CursoMapper cursoMapper) {
        this.cursoController = cursoController;
        this.cursoMapper = cursoMapper;
    }

    @POST
    public Response criarCurso(CursoInputDTO dto) {
        try {
            Curso curso = cursoMapper.toModel(dto);
            Curso criado = cursoController.criarCurso(curso);
            CursoOutputDTO output = cursoMapper.toOutputDTO(criado);

            return Response.status(Response.Status.CREATED).entity(output).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    public Response editarCurso(CursoInputDTO dto) {
        try {
            Curso curso = cursoMapper.toModel(dto);
            cursoController.editarCurso(curso);
            return Response.accepted().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/buscar/{nome}")
    public Response buscarCurso(@PathParam("nome") String nome) {
        try {
            Curso curso = cursoController.buscarCurso(nome);
            CursoOutputDTO output = cursoMapper.toOutputDTO(curso);
            return Response.ok(output).build();
        } catch (RuntimeException | EntidadeNaoLocalizada e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/excluir/{nome}")
    public Response excluirCurso(@PathParam("nome") String nome) {
        try {
            cursoController.excluirCurso(nome);
            return Response.noContent().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}

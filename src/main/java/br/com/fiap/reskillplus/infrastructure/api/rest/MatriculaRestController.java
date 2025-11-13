package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.MatriculaInputDTO;
import br.com.fiap.reskillplus.dto.output.MatriculaOutputDTO;
import br.com.fiap.reskillplus.mapper.MatriculaMapper;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.interfaces.MatriculaController;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/matricula")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MatriculaRestController {

    private final MatriculaController matriculaController;
    private final MatriculaMapper matriculaMapper;

    @Inject
    public MatriculaRestController(MatriculaController matriculaController,
                                   MatriculaMapper matriculaMapper) {
        this.matriculaController = matriculaController;
        this.matriculaMapper = matriculaMapper;
    }

    @POST
    public Response criarMatricula(MatriculaInputDTO dto) {
        try {
            Matricula matricula = matriculaMapper.toModel(dto);
            Matricula criada = matriculaController.criarMatricula(matricula);
            MatriculaOutputDTO output = matriculaMapper.toOutputDTO(criada);

            return Response.status(Response.Status.CREATED).entity(output).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/buscar/{cpf}/{curso}")
    public Response buscarMatricula(@PathParam("cpf") String cpf,
                                    @PathParam("curso") String curso) {
        try {
            Matricula matricula = matriculaController.buscarMatricula(cpf, curso);
            MatriculaOutputDTO output = matriculaMapper.toOutputDTO(matricula);
            return Response.ok(output).build();
        } catch (RuntimeException | EntidadeNaoLocalizada e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/excluir/{cpf}/{curso}")
    public Response excluirMatricula(@PathParam("cpf") String cpf,
                                     @PathParam("curso") String curso) {
        try {
            matriculaController.excluirMatricula(cpf, curso);
            return Response.noContent().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}

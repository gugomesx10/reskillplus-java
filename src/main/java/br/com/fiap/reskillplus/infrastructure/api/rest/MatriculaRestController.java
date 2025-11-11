package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.MatriculaInputDTO;
import br.com.fiap.reskillplus.dto.output.MatriculaOutputDTO;
import br.com.fiap.reskillplus.interfaces.MatriculaController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/matricula")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MatriculaRestController {

    private final MatriculaController matriculaController;

    public MatriculaRestController(MatriculaController matriculaController) {
        this.matriculaController = matriculaController;
    }

    @POST
    public Response cadastrar(MatriculaInputDTO dto) {
        try {
            MatriculaOutputDTO saida = matriculaController.cadastrar(dto);
            return Response.status(Response.Status.CREATED).entity(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("erro", e.getMessage()))
                    .build();
        }
    }

    @GET
    public Response listarTodas() {
        List<MatriculaOutputDTO> matriculas = matriculaController.listarTodas();
        return Response.ok(matriculas).build();
    }

    @GET
    @Path("/usuario/{usuarioId}")
    public Response listarPorUsuario(@PathParam("usuarioId") int usuarioId) {
        List<MatriculaOutputDTO> matriculas = matriculaController.listarPorUsuario(usuarioId);
        return Response.ok(matriculas).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") int id) {
        matriculaController.deletar(id);
        return Response.noContent().build();
    }
}

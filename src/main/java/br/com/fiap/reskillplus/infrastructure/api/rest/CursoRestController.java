package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.CursoInputDTO;
import br.com.fiap.reskillplus.dto.output.CursoOutputDTO;
import br.com.fiap.reskillplus.interfaces.CursoController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/curso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoRestController {

    private final CursoController cursoController;

    public CursoRestController(CursoController cursoController) {
        this.cursoController = cursoController;
    }

    @POST
    public Response cadastrar(CursoInputDTO dto) {
        try {
            CursoOutputDTO saida = cursoController.cadastrar(dto);
            return Response.status(Response.Status.CREATED).entity(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("erro", e.getMessage()))
                    .build();
        }
    }

    @GET
    public Response listarTodos() {
        List<CursoOutputDTO> cursos = cursoController.listarTodos();
        return Response.ok(cursos).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id) {
        CursoOutputDTO curso = cursoController.buscarPorId(id);
        if (curso == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(curso).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") int id) {
        cursoController.deletar(id);
        return Response.noContent().build();
    }
}

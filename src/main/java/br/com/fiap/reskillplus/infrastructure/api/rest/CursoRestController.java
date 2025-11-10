package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.domain.service.CursoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/cursos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoRestController {

    @Inject
    CursoService cursoService;

    @GET
    public List<Curso> listarTodos() {
        return cursoService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Curso buscarPorId(@PathParam("id") Long id) {
        return cursoService.buscarPorId(id);
    }

    @POST
    public Response criar(Curso curso) {
        cursoService.criar(curso);
        return Response.status(Response.Status.CREATED).entity(curso).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Curso curso) {
        curso.setId(id);
        cursoService.atualizar(curso);
        return Response.ok(curso).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        cursoService.remover(id);
        return Response.noContent().build();
    }
}

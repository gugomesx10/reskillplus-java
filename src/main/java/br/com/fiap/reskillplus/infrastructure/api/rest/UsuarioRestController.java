package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.domain.model.Usuario;
import br.com.fiap.reskillplus.domain.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRestController {

    @Inject
    UsuarioService usuarioService;

    @GET
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Usuario buscarPorId(@PathParam("id") Long id) {
        return usuarioService.buscarPorId(id);
    }

    @GET
    @Path("/email/{email}")
    public Usuario buscarPorEmail(@PathParam("email") String email) {
        return usuarioService.buscarPorEmail(email);
    }

    @POST
    public Response cadastrar(Usuario usuario) {
        usuarioService.cadastrar(usuario);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Usuario usuario) {
        usuario.setId(id);
        usuarioService.atualizar(usuario);
        return Response.ok(usuario).build();
    }

    @DELETE
    @Path("/{id}")
    public Response remover(@PathParam("id") Long id) {
        usuarioService.remover(id);
        return Response.noContent().build();
    }
}

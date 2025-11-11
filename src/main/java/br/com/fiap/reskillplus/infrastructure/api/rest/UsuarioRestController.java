package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.UsuarioInputDTO;
import br.com.fiap.reskillplus.dto.output.UsuarioOutputDTO;
import br.com.fiap.reskillplus.interfaces.UsuarioController;
import br.com.fiap.reskillplus.mapper.UsuarioMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRestController {

    private final UsuarioController usuarioController;

    public UsuarioRestController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    @POST
    public Response cadastrar(UsuarioInputDTO dto) {
        try {
            UsuarioOutputDTO saida = usuarioController.cadastrar(dto);
            return Response.status(Response.Status.CREATED).entity(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("erro", e.getMessage()))
                    .build();
        }
    }

    @GET
    public Response listarTodos() {
        List<UsuarioOutputDTO> usuarios = usuarioController.listarTodos();
        return Response.ok(usuarios).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id) {
        UsuarioOutputDTO usuario = usuarioController.buscarPorId(id);
        if (usuario == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(usuario).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") int id) {
        usuarioController.deletar(id);
        return Response.noContent().build();
    }
}

package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.UsuarioInputDTO;
import br.com.fiap.reskillplus.dto.output.UsuarioOutputDTO;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Usuario;
import br.com.fiap.reskillplus.interfaces.UsuarioController;
import br.com.fiap.reskillplus.mapper.UsuarioMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRestController {

    private final UsuarioController usuarioController;
    private final UsuarioMapper usuarioMapper;

    @Inject
    public UsuarioRestController(UsuarioController usuarioController,
                                 UsuarioMapper usuarioMapper) {
        this.usuarioController = usuarioController;
        this.usuarioMapper = usuarioMapper;
    }

    @POST
    public Response criarUsuario(UsuarioInputDTO usuarioInputDTO) {
        try {
            Usuario usuario = usuarioMapper.toModel(usuarioInputDTO);
            Usuario criado = usuarioController.criarUsuario(usuario);
            UsuarioOutputDTO output = usuarioMapper.toOutputDTO(criado);

            return Response.status(Response.Status.CREATED).entity(output).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    public Response editarUsuario(UsuarioInputDTO usuarioInputDTO) {
        try {
            Usuario usuario = usuarioMapper.toModel(usuarioInputDTO);
            usuarioController.editarUsuario(usuario);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/buscar/{cpf}")
    public Response buscarUsuario(@PathParam("cpf") String cpf) {
        try {
            Usuario usuario = usuarioController.buscarUsuario(cpf);
            UsuarioOutputDTO output = usuarioMapper.toOutputDTO(usuario);
            return Response.ok(output).build();
        } catch (RuntimeException | EntidadeNaoLocalizada e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/validar/{cpf}/{senha}")
    public Response validarUsuario(@PathParam("cpf") String cpf, @PathParam("senha") String senha) {
        try {
            Usuario usuario = usuarioController.validarUsuario(cpf, senha);
            UsuarioOutputDTO output = usuarioMapper.toOutputDTO(usuario);
            return Response.ok(output).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/excluir/{cpf}")
    public Response excluirUsuario(@PathParam("cpf") String cpf) {
        try {
            usuarioController.excluirUsuario(cpf);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}

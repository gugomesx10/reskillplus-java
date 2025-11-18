package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.domain.service.PagamentoService;
import br.com.fiap.reskillplus.interfaces.PagamentoController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pagamento")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PagamentoRestController {

    private final PagamentoController controller;

    public PagamentoRestController(PagamentoController controller) {
        this.controller = controller;
    }

    @POST
    public Response pagar(br.com.fiap.reskillplus.dto.input.PagamentoInputDTO dto) {
        return Response.status(Response.Status.CREATED).entity(
                controller.pagar(dto)
        ).build();
    }

    @GET
    public Response listar() {
        return Response.ok(controller.listar()).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        return Response.ok(controller.buscar(id)).build();
    }

    @PUT
    @Path("/{id}/status/{status}")
    public Response atualizarStatus(
            @PathParam("id") Long id,
            @PathParam("status") String status
    ) {
        return Response.ok(controller.atualizarStatus(id, status)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response remover(@PathParam("id") Long id) {
        controller.remover(id);
        return Response.noContent().build();
    }
}

package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.dto.input.HabilidadeInputDTO;
import br.com.fiap.reskillplus.dto.output.HabilidadeOutputDTO;
import br.com.fiap.reskillplus.interfaces.HabilidadeController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/habilidade")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HabilidadeRestController {

    private final HabilidadeController habilidadeController;

    public HabilidadeRestController(HabilidadeController habilidadeController) {
        this.habilidadeController = habilidadeController;
    }

    @POST
    public Response cadastrar(HabilidadeInputDTO dto) {
        try {
            HabilidadeOutputDTO saida = habilidadeController.cadastrar(dto);
            return Response.status(Response.Status.CREATED).entity(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("erro", e.getMessage()))
                    .build();
        }
    }

    @GET
    public Response listarTodas() {
        List<HabilidadeOutputDTO> habilidades = habilidadeController.listarTodas();
        return Response.ok(habilidades).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id) {
        HabilidadeOutputDTO habilidade = habilidadeController.buscarPorId(id);
        if (habilidade == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(habilidade).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") int id) {
        habilidadeController.deletar(id);
        return Response.noContent().build();
    }
}

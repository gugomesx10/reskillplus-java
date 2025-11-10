package br.com.fiap.reskillplus.infrastructure.api.rest;

import br.com.fiap.reskillplus.domain.model.Feedback;
import br.com.fiap.reskillplus.domain.service.FeedbackService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/feedbacks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FeedbackRestController {

    @Inject
    FeedbackService feedbackService;

    @GET
    public List<Feedback> listarTodos() {
        return feedbackService.listarPorCurso(null);
    }

    @GET
    @Path("/{id}")
    public Feedback buscarPorId(@PathParam("id") Long id) {
        return feedbackService.buscarPorId(id);
    }

    @POST
    public Response registrar(Feedback feedback) {
        feedbackService.registrar(feedback);
        return Response.status(Response.Status.CREATED).entity(feedback).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        feedbackService.deletar(id);
        return Response.noContent().build();
    }
}

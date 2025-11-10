package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Feedback;
import br.com.fiap.reskillplus.domain.service.FeedbackService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FeedbackControllerImpl implements FeedbackController {

    private final FeedbackService feedbackService;

    @Inject
    public FeedbackControllerImpl(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Override
    public void registrarFeedback(Feedback feedback) {
        feedbackService.registrarFeedback(feedback);
    }

    @Override
    public List<Feedback> listarPorCurso(Long cursoId) {
        return feedbackService.listarPorCurso(cursoId);
    }
}

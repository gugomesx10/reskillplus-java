package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Feedback;
import java.util.List;

public interface FeedbackController {
    void registrarFeedback(Feedback feedback);
    List<Feedback> listarPorCurso(Long cursoId);
}

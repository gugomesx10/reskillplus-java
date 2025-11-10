package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.domain.model.Feedback;
import br.com.fiap.reskillplus.domain.repository.FeedbackRepository;
import br.com.fiap.reskillplus.domain.service.FeedbackService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FeedbackServiceImpl implements FeedbackService {

    @Inject
    FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
    }

    @Override
    public void registrar(Feedback feedback) {
        feedbackRepository.salvar(feedback);
    }

    @Override
    public Feedback buscarPorId(Long id) {
        return feedbackRepository.buscarPorId(id);
    }

    @Override
    public List<Feedback> listarPorCurso(Long cursoId) {
        return feedbackRepository.listarPorCurso(cursoId);
    }

    @Override
    public List<Feedback> listarPorUsuario(Long usuarioId) {
        return feedbackRepository.listarPorUsuario(usuarioId);
    }

    @Override
    public void deletar(Long id) {
        feedbackRepository.deletar(id);
    }

    @Override
    public void registrarFeedback(Feedback feedback) {

    }
}

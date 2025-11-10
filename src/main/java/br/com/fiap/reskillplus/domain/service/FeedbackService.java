package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Feedback;
import java.util.List;

public interface FeedbackService {
    void registrar(Feedback feedback);
    Feedback buscarPorId(Long id);
    List<Feedback> listarPorCurso(Long cursoId);
    List<Feedback> listarPorUsuario(Long usuarioId);
    void deletar(Long id);
}

package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Feedback;
import java.util.List;

public interface FeedbackRepository {
    void salvar(Feedback feedback);
    Feedback buscarPorId(Long id);
    List<Feedback> listarTodos();
    List<Feedback> listarPorCurso(Long cursoId);
    List<Feedback> listarPorUsuario(Long usuarioId);
    void deletar(Long id);
}

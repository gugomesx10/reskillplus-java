package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Matricula;
import java.util.List;

public interface MatriculaService {

    void matricular(Matricula matricula);

    Matricula buscarPorId(Long id);

    List<Matricula> listarPorUsuario(Long usuarioId);

    List<Matricula> listarPorCurso(Long cursoId);

    void atualizar(Matricula matricula);

    void cancelar(Long id);

    void atualizarProgresso(Long id, Integer progresso);
}

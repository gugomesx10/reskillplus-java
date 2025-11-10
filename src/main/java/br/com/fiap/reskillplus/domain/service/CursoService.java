package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Curso;
import java.util.List;

public interface CursoService {

    void criar(Curso curso);

    Curso buscarPorId(Long id);

    List<Curso> listarTodos();

    void atualizar(Curso curso);

    void remover(Long id);
}

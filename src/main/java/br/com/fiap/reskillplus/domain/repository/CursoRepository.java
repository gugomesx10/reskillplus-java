package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Curso;
import java.util.List;

public interface CursoRepository {
    void salvar(Curso curso);
    Curso buscarPorId(Long id);
    List<Curso> listarTodos();
    void atualizar(Curso curso);
    void deletar(Long id);
}

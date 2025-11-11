package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Curso;
import java.util.List;

public interface CursoRepository {

    void salvar(Curso curso);
    void atualizar(Curso curso);
    void deletar(int id);
    Curso buscarPorId(int id);
    List<Curso> listarTodos();
}

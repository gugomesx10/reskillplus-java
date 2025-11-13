package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

public interface CursoRepository {

    Curso criarCurso(Curso curso);
    void editarCurso(Curso curso);
    Curso buscarCurso(String nome) throws EntidadeNaoLocalizada;
    void excluirCurso(String nome);

    Curso buscarCurso(int id) throws EntidadeNaoLocalizada;
}

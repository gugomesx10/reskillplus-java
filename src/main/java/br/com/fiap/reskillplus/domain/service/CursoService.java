package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

public interface CursoService {
    Curso criarCurso(Curso curso);
    void editarCurso(Curso curso);
    Curso buscarCurso(String nome_curso) throws EntidadeNaoLocalizada;
    void excluirCurso(String nome_curso);
}

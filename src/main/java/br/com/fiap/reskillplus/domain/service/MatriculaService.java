package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

public interface MatriculaService {
    Matricula criarMatricula(Matricula matricula);
    void editarMatricula(Matricula matricula);
    Matricula buscarMatricula(String cpf_usuario, String nome_curso) throws EntidadeNaoLocalizada;
    void excluirMatricula(String cpf_usuario, String nome_curso);
}

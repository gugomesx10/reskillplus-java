package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

import java.util.List;

public interface MatriculaRepository {

    Matricula criarMatricula(Matricula matricula);
    void editarMatricula(Matricula matricula);
    Matricula buscarMatricula(String cpf, String nomeCurso) throws EntidadeNaoLocalizada;
    void excluirMatricula(String cpf, String nomeCurso);
    List<Matricula> listarMatriculasPorUsuario(String cpf);
}

package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

public interface MatriculaController {

    Matricula criarMatricula(Matricula matricula);
    void editarMatricula(Matricula matricula);
    Matricula buscarMatricula(String cpf, String curso) throws EntidadeNaoLocalizada;
    void excluirMatricula(String cpf, String curso);
}

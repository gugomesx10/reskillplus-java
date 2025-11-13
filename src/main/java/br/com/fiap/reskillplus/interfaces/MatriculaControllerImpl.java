package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.domain.service.MatriculaService;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

import jakarta.enterprise.inject.Vetoed;
import jakarta.inject.Inject;

@Vetoed
public class MatriculaControllerImpl implements MatriculaController {

    private final MatriculaService matriculaService;

    @Inject
    public MatriculaControllerImpl(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @Override
    public Matricula criarMatricula(Matricula matricula) {
        return matriculaService.criarMatricula(matricula);
    }

    @Override
    public void editarMatricula(Matricula matricula) {
        matriculaService.editarMatricula(matricula);
    }

    @Override
    public Matricula buscarMatricula(String cpf, String curso)
            throws EntidadeNaoLocalizada {
        return matriculaService.buscarMatricula(cpf, curso);
    }

    @Override
    public void excluirMatricula(String cpf, String curso) {
        matriculaService.excluirMatricula(cpf, curso);
    }
}

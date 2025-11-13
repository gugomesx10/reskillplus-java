package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.application.exceptions.MatriculaJaExisteException;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.domain.repository.MatriculaRepository;
import br.com.fiap.reskillplus.domain.service.MatriculaService;

public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public Matricula criarMatricula(Matricula matricula) {
        try {
            buscarMatricula(matricula.getCpf_usuario(), matricula.getNome_curso());
            throw new MatriculaJaExisteException("Matrícula já existente");
        } catch (EntidadeNaoLocalizada e) {
            return matriculaRepository.criarMatricula(matricula);
        }
    }

    @Override
    public void editarMatricula(Matricula matricula) {
        try {
            buscarMatricula(matricula.getCpf_usuario(), matricula.getNome_curso());
            matriculaRepository.editarMatricula(matricula);
        } catch (EntidadeNaoLocalizada e) {
            throw new RuntimeException("Matrícula não encontrada");
        }
    }

    @Override
    public Matricula buscarMatricula(String cpf, String curso) throws EntidadeNaoLocalizada {
        return matriculaRepository.buscarMatricula(cpf, curso);
    }

    @Override
    public void excluirMatricula(String cpf, String curso) {
        try {
            buscarMatricula(cpf, curso);
            matriculaRepository.excluirMatricula(cpf, curso);
        } catch (EntidadeNaoLocalizada e) {
            throw new RuntimeException("Matrícula não encontrada");
        }
    }
}

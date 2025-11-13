package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.application.exceptions.CursoJaExisteException;
import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.domain.repository.CursoRepository;
import br.com.fiap.reskillplus.domain.service.CursoService;

public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Curso criarCurso(Curso curso) {
        try {
            buscarCurso(curso.getNome_curso());
            throw new CursoJaExisteException("Curso já cadastrado");
        } catch (EntidadeNaoLocalizada e) {
            return cursoRepository.criarCurso(curso);
        }
    }

    @Override
    public void editarCurso(Curso curso) {
        try {
            Curso existente = buscarCurso(curso.getNome_curso());
            cursoRepository.editarCurso(curso);
        } catch (EntidadeNaoLocalizada e) {
            throw new RuntimeException("Curso não encontrado");
        }
    }

    @Override
    public Curso buscarCurso(String nomeCurso) throws EntidadeNaoLocalizada {
        return cursoRepository.buscarCurso(nomeCurso);
    }

    @Override
    public void excluirCurso(String nomeCurso) {
        try {
            Curso existente = buscarCurso(nomeCurso);
            cursoRepository.excluirCurso(nomeCurso);
        } catch (EntidadeNaoLocalizada e) {
            throw new RuntimeException("Curso não encontrado");
        }
    }
}

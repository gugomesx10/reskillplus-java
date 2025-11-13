package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.domain.service.CursoService;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CursoControllerImpl implements CursoController {

    private final CursoService cursoService;

    @Inject
    public CursoControllerImpl(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @Override
    public Curso criarCurso(Curso curso) {
        return cursoService.criarCurso(curso);
    }

    @Override
    public void editarCurso(Curso curso) {
        cursoService.editarCurso(curso);
    }

    @Override
    public Curso buscarCurso(String nome) throws EntidadeNaoLocalizada {
        return cursoService.buscarCurso(nome);
    }

    @Override
    public void excluirCurso(String nome) {
        cursoService.excluirCurso(nome);
    }
}

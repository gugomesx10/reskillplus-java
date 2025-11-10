package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.domain.service.CursoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CursoControllerImpl implements CursoController {

    private final CursoService cursoService;

    @Inject
    public CursoControllerImpl(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @Override
    public void criarCurso(Curso curso) {
        cursoService.criar(curso);
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoService.listarTodos();
    }

    @Override
    public Curso buscarPorId(Long id) {
        return cursoService.buscarPorId(id);
    }

    @Override
    public void deletarCurso(Long id) {
        cursoService.remover(id);
    }
}

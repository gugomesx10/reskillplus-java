package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.domain.repository.CursoRepository;
import br.com.fiap.reskillplus.domain.service.CursoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CursoServiceImpl implements CursoService {

    @Inject
    CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
    }

    @Override
    public void criar(Curso curso) {
        cursoRepository.salvar(curso);
    }

    @Override
    public Curso buscarPorId(Long id) {
        return cursoRepository.buscarPorId(id);
    }

    @Override
    public List<Curso> listarTodos() {
        return cursoRepository.listarTodos();
    }

    @Override
    public void atualizar(Curso curso) {
        cursoRepository.atualizar(curso);
    }

    @Override
    public void remover(Long id) {
        cursoRepository.deletar(id);
    }
}

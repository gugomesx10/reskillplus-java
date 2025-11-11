package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.domain.repository.CursoRepository;
import br.com.fiap.reskillplus.domain.service.CursoDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CursoServiceImpl {

    @Inject
    CursoRepository repository;

    @Inject
    CursoDomainService domainService;

    public CursoServiceImpl(CursoRepository cursoRepository) {
    }

    public Curso cadastrar(Curso curso) {
        if (!domainService.validarCurso(curso))
            throw new IllegalArgumentException("Dados do curso inválidos.");
        repository.salvar(curso);
        return curso;
    }

    public List<Curso> listarTodos() {
        return repository.listarTodos();
    }

    public Curso buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public void atualizar(Curso curso) {
        repository.atualizar(curso);
    }

    public void deletar(int id) {
        repository.deletar(id);
    }
}

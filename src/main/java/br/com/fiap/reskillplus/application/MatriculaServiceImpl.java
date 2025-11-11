package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.domain.repository.MatriculaRepository;
import br.com.fiap.reskillplus.domain.service.MatriculaDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class MatriculaServiceImpl {

    @Inject
    MatriculaRepository repository;

    @Inject
    MatriculaDomainService domainService;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository) {
    }

    public Matricula cadastrar(Matricula matricula) {
        if (!domainService.podeMatricular(matricula))
            throw new IllegalArgumentException("Matrícula inválida.");
        repository.salvar(matricula);
        return matricula;
    }

    public void concluir(int id) {
        Matricula matricula = repository.buscarPorId(id);
        domainService.concluirCurso(matricula);
        repository.atualizarProgresso(id, matricula.isConcluido());
    }

    public List<Matricula> listarTodas() {
        return repository.listarTodas();
    }

    public List<Matricula> listarPorUsuario(int usuarioId) {
        return repository.listarPorUsuario(usuarioId);
    }

    public void deletar(int id) {
        repository.deletar(id);
    }
}

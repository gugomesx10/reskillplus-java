package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.domain.repository.MatriculaRepository;
import br.com.fiap.reskillplus.domain.service.MatriculaService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class MatriculaServiceImpl implements MatriculaService {

    @Inject
    MatriculaRepository matriculaRepository;

    @Override
    public void matricular(Matricula matricula) {
        matriculaRepository.salvar(matricula);
    }

    @Override
    public List<Matricula> listarPorUsuario(Long usuarioId) {
        return matriculaRepository.listarPorUsuario(usuarioId);
    }

    @Override
    public void atualizarProgresso(Long id, Integer progresso) {
        matriculaRepository.atualizarProgresso(id, progresso);
    }
}

package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.domain.service.MatriculaService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class MatriculaControllerImpl implements MatriculaController {

    private final MatriculaService matriculaService;

    @Inject
    public MatriculaControllerImpl(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @Override
    public void matricular(Matricula matricula) {
        matriculaService.matricular(matricula);
    }

    @Override
    public List<Matricula> listarPorUsuario(Long usuarioId) {
        return matriculaService.listarPorUsuario(usuarioId);
    }

    @Override
    public void atualizarProgresso(Long id, Integer progresso) {
        matriculaService.atualizarProgresso(id, progresso);
    }
}

package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.domain.service.HabilidadeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class HabilidadeControllerImpl implements HabilidadeController {

    private final HabilidadeService habilidadeService;

    @Inject
    public HabilidadeControllerImpl(HabilidadeService habilidadeService) {
        this.habilidadeService = habilidadeService;
    }

    @Override
    public void adicionar(Habilidade habilidade) {
        habilidadeService.adicionar(habilidade);
    }

    @Override
    public List<Habilidade> listarPorUsuario(Long usuarioId) {
        return habilidadeService.listarPorUsuario(usuarioId);
    }
}

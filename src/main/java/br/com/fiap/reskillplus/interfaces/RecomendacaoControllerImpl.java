package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.domain.service.RecomendacaoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class RecomendacaoControllerImpl implements RecomendacaoController {

    private final RecomendacaoService recomendacaoService;

    @Inject
    public RecomendacaoControllerImpl(RecomendacaoService recomendacaoService) {
        this.recomendacaoService = recomendacaoService;
    }

    @Override
    public void gerar(Recomendacao recomendacao) {
        recomendacaoService.gerar(recomendacao);
    }

    @Override
    public List<Recomendacao> listarPorUsuario(Long usuarioId) {
        return recomendacaoService.listarPorUsuario(usuarioId);
    }
}

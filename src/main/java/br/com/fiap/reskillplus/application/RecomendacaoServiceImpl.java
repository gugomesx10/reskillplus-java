package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.domain.repository.RecomendacaoRepository;
import br.com.fiap.reskillplus.domain.service.RecomendacaoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class RecomendacaoServiceImpl implements RecomendacaoService {

    @Inject
    RecomendacaoRepository recomendacaoRepository;

    @Override
    public void gerar(Recomendacao recomendacao) {
        recomendacaoRepository.salvar(recomendacao);
    }

    @Override
    public List<Recomendacao> listarPorUsuario(Long usuarioId) {
        return recomendacaoRepository.listarPorUsuario(usuarioId);
    }
}

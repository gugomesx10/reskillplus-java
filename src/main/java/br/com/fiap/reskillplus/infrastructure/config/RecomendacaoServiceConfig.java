package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.application.RecomendacaoServiceImpl;
import br.com.fiap.reskillplus.domain.repository.RecomendacaoRepository;
import br.com.fiap.reskillplus.domain.service.RecomendacaoService;

import jakarta.enterprise.context.RequestScoped;

public class RecomendacaoServiceConfig {

    private final RecomendacaoRepository recomendacaoRepository;

    public RecomendacaoServiceConfig(RecomendacaoRepository recomendacaoRepository) {
        this.recomendacaoRepository = recomendacaoRepository;
    }

    @RequestScoped
    public RecomendacaoService recomendacaoService() {
        return new RecomendacaoServiceImpl(recomendacaoRepository);
    }
}

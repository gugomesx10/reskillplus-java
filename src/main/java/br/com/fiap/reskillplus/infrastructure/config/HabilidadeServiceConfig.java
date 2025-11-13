package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.application.HabilidadeServiceImpl;
import br.com.fiap.reskillplus.domain.repository.HabilidadeRepository;
import br.com.fiap.reskillplus.domain.service.HabilidadeService;

import jakarta.enterprise.context.RequestScoped;

public class HabilidadeServiceConfig {

    private final HabilidadeRepository habilidadeRepository;

    public HabilidadeServiceConfig(HabilidadeRepository habilidadeRepository) {
        this.habilidadeRepository = habilidadeRepository;
    }

    @RequestScoped
    public HabilidadeService habilidadeService() {
        return new HabilidadeServiceImpl(habilidadeRepository);
    }
}

package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.application.PagamentoServiceImpl;
import br.com.fiap.reskillplus.domain.repository.PagamentoRepository;
import br.com.fiap.reskillplus.domain.service.PagamentoService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

@ApplicationScoped
public class PagamentoServiceConfig {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoServiceConfig(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @RequestScoped
    public PagamentoService pagamentoService() {
        return new PagamentoServiceImpl(pagamentoRepository);
    }
}

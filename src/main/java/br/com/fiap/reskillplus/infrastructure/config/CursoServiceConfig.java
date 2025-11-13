package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.application.CursoServiceImpl;
import br.com.fiap.reskillplus.domain.repository.CursoRepository;
import br.com.fiap.reskillplus.domain.service.CursoService;

import jakarta.enterprise.context.RequestScoped;

public class CursoServiceConfig {

    private final CursoRepository cursoRepository;

    public CursoServiceConfig(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @RequestScoped
    public CursoService cursoService() {
        return new CursoServiceImpl(cursoRepository);
    }
}

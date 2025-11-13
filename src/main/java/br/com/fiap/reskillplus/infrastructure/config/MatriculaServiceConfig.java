package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.application.MatriculaServiceImpl;
import br.com.fiap.reskillplus.domain.repository.MatriculaRepository;
import br.com.fiap.reskillplus.domain.service.MatriculaService;

import jakarta.enterprise.context.RequestScoped;

public class MatriculaServiceConfig {

    private final MatriculaRepository matriculaRepository;

    public MatriculaServiceConfig(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @RequestScoped
    public MatriculaService matriculaService() {
        return new MatriculaServiceImpl(matriculaRepository);
    }
}

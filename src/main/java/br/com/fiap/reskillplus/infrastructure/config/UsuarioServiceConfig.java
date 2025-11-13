package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.application.UsuarioServiceImpl;
import br.com.fiap.reskillplus.domain.repository.UsuarioRepository;
import br.com.fiap.reskillplus.domain.service.UsuarioService;

import jakarta.enterprise.context.RequestScoped;

public class UsuarioServiceConfig {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceConfig(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @RequestScoped
    public UsuarioService usuarioService() {
        return new UsuarioServiceImpl(usuarioRepository);
    }
}

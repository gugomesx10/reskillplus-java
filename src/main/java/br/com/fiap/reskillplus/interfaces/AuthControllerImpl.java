package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.AuthUsuario;
import br.com.fiap.reskillplus.domain.service.AuthService;
import br.com.fiap.reskillplus.dto.input.AuthInputDTO;
import br.com.fiap.reskillplus.dto.output.AuthOutputDTO;
import br.com.fiap.reskillplus.mapper.AuthMapper;

import jakarta.enterprise.inject.Vetoed;

@Vetoed
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;
    private final AuthMapper mapper;

    public AuthControllerImpl(AuthService authService, AuthMapper mapper) {
        this.authService = authService;
        this.mapper = mapper;
    }

    @Override
    public AuthOutputDTO autenticar(AuthInputDTO dto) {
        AuthUsuario usuario = authService.autenticarGitHub(dto);
        return mapper.toOutput(usuario);
    }

    @Override
    public String gerarUrlLoginGithub() {
        return authService.gerarUrlLoginGithub();
    }
}

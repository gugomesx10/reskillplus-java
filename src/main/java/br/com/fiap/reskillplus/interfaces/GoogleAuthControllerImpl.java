package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.service.GoogleAuthService;
import br.com.fiap.reskillplus.dto.input.AuthInputDTO;
import br.com.fiap.reskillplus.dto.output.AuthOutputDTO;
import br.com.fiap.reskillplus.mapper.AuthMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GoogleAuthControllerImpl implements GoogleAuthController {

    private final GoogleAuthService service;
    private final AuthMapper mapper;

    @Inject
    public GoogleAuthControllerImpl(GoogleAuthService service, AuthMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public String gerarUrlLogin() {
        return service.gerarUrlLogin();
    }

    @Override
    public AuthOutputDTO autenticar(AuthInputDTO dto) {
        return mapper.toOutput(service.autenticar(dto));
    }
}

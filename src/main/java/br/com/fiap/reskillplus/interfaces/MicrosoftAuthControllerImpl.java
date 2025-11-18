package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.service.MicrosoftAuthService;
import br.com.fiap.reskillplus.dto.input.AuthInputDTO;
import br.com.fiap.reskillplus.dto.output.AuthOutputDTO;
import br.com.fiap.reskillplus.mapper.AuthMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MicrosoftAuthControllerImpl implements MicrosoftAuthController {

    @Inject
    MicrosoftAuthService service;

    @Inject
    AuthMapper mapper;

    @Override
    public String gerarUrlLogin() {
        return service.gerarUrlLogin();
    }

    @Override
    public AuthOutputDTO autenticar(AuthInputDTO dto) {
        return mapper.toOutput(service.autenticar(dto.getCode(), dto.getRedirectUri()));
    }
}

package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.AuthUsuario;

public interface MicrosoftAuthService {

    String gerarUrlLogin();

    AuthUsuario autenticar(String code, String redirectUri);
}

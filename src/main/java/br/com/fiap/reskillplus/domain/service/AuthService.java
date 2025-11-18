package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.AuthUsuario;
import br.com.fiap.reskillplus.dto.input.AuthInputDTO;

public interface AuthService {
    AuthUsuario autenticarGitHub(AuthInputDTO input);
    String gerarUrlLoginGithub();
}

package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.dto.input.AuthInputDTO;
import br.com.fiap.reskillplus.dto.output.AuthOutputDTO;

public interface AuthController {
    AuthOutputDTO autenticar(AuthInputDTO dto);
    String gerarUrlLoginGithub();
}

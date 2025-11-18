package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.dto.input.AuthInputDTO;
import br.com.fiap.reskillplus.dto.output.AuthOutputDTO;

public interface GoogleAuthController {

    String gerarUrlLogin();

    AuthOutputDTO autenticar(AuthInputDTO dto);
}

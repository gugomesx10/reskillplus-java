package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.dto.input.AuthInputDTO;
import br.com.fiap.reskillplus.dto.output.AuthOutputDTO;

public interface MicrosoftAuthController {

    String gerarUrlLogin();

    AuthOutputDTO autenticar(AuthInputDTO dto);
}

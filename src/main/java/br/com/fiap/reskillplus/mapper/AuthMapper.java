package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.AuthUsuario;
import br.com.fiap.reskillplus.dto.output.AuthOutputDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthMapper {

    public AuthOutputDTO toOutput(AuthUsuario model) {
        if (model == null) return null;

        return new AuthOutputDTO(
                model.getNome(),
                model.getEmail(),
                model.getAvatarUrl(),
                model.getAccessToken()
        );
    }
}

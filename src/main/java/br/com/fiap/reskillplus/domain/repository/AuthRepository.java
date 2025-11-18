package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.AuthUsuario;

public interface AuthRepository {

    AuthUsuario buscarPorProviderId(String provider, String providerId);

    AuthUsuario salvar(AuthUsuario usuario);
}

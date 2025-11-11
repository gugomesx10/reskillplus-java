package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioDomainService {

    public boolean validarEmail(Usuario usuario) {
        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            return false;
        }
        return true;
    }

    public boolean validarSenha(Usuario usuario) {
        String senha = usuario.getSenha();
        return senha != null && senha.length() >= 6;
    }

    public void atualizarPapel(Usuario usuario, String novoPapel) {
        usuario.setPapel(novoPapel);
    }
}

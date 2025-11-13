package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.service.UsuarioService;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Usuario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService usuarioService;

    @Inject
    public UsuarioControllerImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        usuarioService.editarUsuario(usuario);
    }

    @Override
    public Usuario buscarUsuario(String cpf) throws EntidadeNaoLocalizada {
        return usuarioService.buscarUsuario(cpf);
    }

    @Override
    public Usuario validarUsuario(String cpf, String senha) {
        return usuarioService.validarUsuario(cpf, senha);
    }

    @Override
    public void excluirUsuario(String cpf) {
        usuarioService.excluirUsuario(cpf);
    }
}

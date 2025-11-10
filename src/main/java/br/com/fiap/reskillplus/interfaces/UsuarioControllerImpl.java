package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Usuario;
import br.com.fiap.reskillplus.domain.service.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService usuarioService;

    @Inject
    public UsuarioControllerImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void criarUsuario(Usuario usuario) {
        usuarioService.criarUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioService.buscarPorEmail(email);
    }
}

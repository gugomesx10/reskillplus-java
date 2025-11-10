package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Usuario;
import java.util.List;

public interface UsuarioController {
    void criarUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Usuario buscarPorEmail(String email);
}

package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Usuario;
import java.util.List;

public interface UsuarioService {

    void cadastrar(Usuario usuario);

    Usuario buscarPorId(Long id);

    Usuario buscarPorEmail(String email);

    List<Usuario> listarTodos();

    void atualizar(Usuario usuario);

    void remover(Long id);

    void criarUsuario(Usuario usuario);
}

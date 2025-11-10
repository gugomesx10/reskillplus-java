package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Usuario;
import java.util.List;

public interface UsuarioRepository {
    void salvar(Usuario usuario);
    Usuario buscarPorId(Long id);
    Usuario buscarPorEmail(String email);
    List<Usuario> listarTodos();
    void atualizar(Usuario usuario);
    void deletar(Long id);
}

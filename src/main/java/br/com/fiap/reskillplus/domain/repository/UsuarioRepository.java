package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Usuario;
import java.util.List;

public interface UsuarioRepository {

    void salvar(Usuario usuario);
    void atualizar(Usuario usuario);
    void deletar(int id);
    Usuario buscarPorId(int id);
    Usuario buscarPorEmail(String email);
    List<Usuario> listarTodos();
}

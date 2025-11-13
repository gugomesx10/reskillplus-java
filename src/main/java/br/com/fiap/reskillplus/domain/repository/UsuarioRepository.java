package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Usuario;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

public interface UsuarioRepository {

    Usuario criarUsuario(Usuario usuario);
    void editarUsuario(Usuario usuario);
    Usuario buscarUsuario(String cpf) throws EntidadeNaoLocalizada;
    Usuario validarUsuario(String cpf, String senha);
    void excluirUsuario(String cpf);
}

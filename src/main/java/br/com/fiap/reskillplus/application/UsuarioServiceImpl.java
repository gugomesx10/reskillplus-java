package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.application.exceptions.UsuarioJaExisteException;
import br.com.fiap.reskillplus.domain.model.Usuario;
import br.com.fiap.reskillplus.domain.repository.UsuarioRepository;
import br.com.fiap.reskillplus.domain.service.UsuarioService;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Usuario criarUsuario(Usuario usuario) {
        try{
            buscarUsuario(usuario.getCpf_usuario());
            throw new UsuarioJaExisteException("Usuario já cadastrado");
        } catch (EntidadeNaoLocalizada e) {
            return usuarioRepository.criarUsuario(usuario);
        }
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        try{
            Usuario usurioExistente = buscarUsuario(usuario.getCpf_usuario());
            usuarioRepository.editarUsuario(usuario);
        } catch (EntidadeNaoLocalizada e) {
            throw new UsuarioJaExisteException("Usuario não encontrado");
        }
    }

    @Override
    public Usuario buscarUsuario(String cpf) throws EntidadeNaoLocalizada {
        return usuarioRepository.buscarUsuario(cpf);
    }

    @Override
    public Usuario validarUsuario(String cpf, String senha) {
        return usuarioRepository.validarUsuario(cpf, senha);
    }

    @Override
    public void excluirUsuario(String cpf) {
        try {
            Usuario usuarioExistente = buscarUsuario(cpf);
            usuarioRepository.excluirUsuario(cpf);
        } catch (EntidadeNaoLocalizada e) {
            throw new UsuarioJaExisteException("Usuario não encontrado");
        }
    }
}
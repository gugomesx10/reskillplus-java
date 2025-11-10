package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.domain.model.Usuario;
import br.com.fiap.reskillplus.domain.repository.UsuarioRepository;
import br.com.fiap.reskillplus.domain.service.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
    }

    @Override
    public void cadastrar(Usuario usuario) {
        usuarioRepository.salvar(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.buscarPorId(id);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.buscarPorEmail(email);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.listarTodos();
    }

    @Override
    public void atualizar(Usuario usuario) {
        usuarioRepository.atualizar(usuario);
    }

    @Override
    public void remover(Long id) {
        usuarioRepository.deletar(id);
    }

    @Override
    public void criarUsuario(Usuario usuario) {

    }
}

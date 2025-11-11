package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.domain.model.Usuario;
import br.com.fiap.reskillplus.domain.repository.UsuarioRepository;
import br.com.fiap.reskillplus.domain.service.UsuarioDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UsuarioServiceImpl {

    @Inject
    UsuarioRepository repository;

    @Inject
    UsuarioDomainService domainService;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
    }

    public Usuario cadastrar(Usuario usuario) {
        if (!domainService.validarEmail(usuario))
            throw new IllegalArgumentException("E-mail inválido.");

        repository.salvar(usuario);
        return usuario;
    }

    public List<Usuario> listarTodos() {
        return repository.listarTodos();
    }

    public Usuario buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public void atualizar(Usuario usuario) {
        repository.atualizar(usuario);
    }

    public void deletar(int id) {
        repository.deletar(id);
    }
}

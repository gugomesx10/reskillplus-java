package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.application.UsuarioServiceImpl;
import br.com.fiap.reskillplus.dto.input.UsuarioInputDTO;
import br.com.fiap.reskillplus.dto.output.UsuarioOutputDTO;
import br.com.fiap.reskillplus.mapper.UsuarioMapper;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioServiceImpl usuarioServiceImpl;

    public UsuarioControllerImpl(UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    @Override
    public UsuarioOutputDTO cadastrar(UsuarioInputDTO dto) {
        return UsuarioMapper.toOutputDTO(usuarioServiceImpl.cadastrar(UsuarioMapper.toEntity(dto)));
    }

    @Override
    public UsuarioOutputDTO buscarPorId(int id) {
        return UsuarioMapper.toOutputDTO(usuarioServiceImpl.buscarPorId(id));
    }

    @Override
    public List<UsuarioOutputDTO> listarTodos() {
        return UsuarioMapper.toOutputList(usuarioServiceImpl.listarTodos());
    }

    @Override
    public void deletar(int id) {
        usuarioServiceImpl.deletar(id);
    }
}

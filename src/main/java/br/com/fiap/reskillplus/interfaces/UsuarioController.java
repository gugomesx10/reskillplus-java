package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.dto.input.UsuarioInputDTO;
import br.com.fiap.reskillplus.dto.output.UsuarioOutputDTO;
import java.util.List;

public interface UsuarioController {
    UsuarioOutputDTO cadastrar(UsuarioInputDTO dto);
    UsuarioOutputDTO buscarPorId(int id);
    List<UsuarioOutputDTO> listarTodos();
    void deletar(int id);
}

package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.dto.input.CursoInputDTO;
import br.com.fiap.reskillplus.dto.output.CursoOutputDTO;
import java.util.List;

public interface CursoController {
    CursoOutputDTO cadastrar(CursoInputDTO dto);
    CursoOutputDTO buscarPorId(int id);
    List<CursoOutputDTO> listarTodos();
    void deletar(int id);
}

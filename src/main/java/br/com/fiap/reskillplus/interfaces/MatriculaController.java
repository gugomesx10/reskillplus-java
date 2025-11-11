package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.dto.input.MatriculaInputDTO;
import br.com.fiap.reskillplus.dto.output.MatriculaOutputDTO;
import java.util.List;

public interface MatriculaController {
    MatriculaOutputDTO cadastrar(MatriculaInputDTO dto);
    List<MatriculaOutputDTO> listarTodas();
    List<MatriculaOutputDTO> listarPorUsuario(int usuarioId);
    void deletar(int id);
}

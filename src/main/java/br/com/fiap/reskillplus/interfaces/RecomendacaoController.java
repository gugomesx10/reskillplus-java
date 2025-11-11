package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.dto.input.RecomendacaoInputDTO;
import br.com.fiap.reskillplus.dto.output.RecomendacaoOutputDTO;
import java.util.List;

public interface RecomendacaoController {
    RecomendacaoOutputDTO gerar(RecomendacaoInputDTO dto);
    List<RecomendacaoOutputDTO> listarTodas();
    List<RecomendacaoOutputDTO> listarPorUsuario(int usuarioId);
    void deletar(int id);
}

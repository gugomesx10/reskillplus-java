package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.dto.input.HabilidadeInputDTO;
import br.com.fiap.reskillplus.dto.output.HabilidadeOutputDTO;
import java.util.List;

public interface HabilidadeController {
    HabilidadeOutputDTO cadastrar(HabilidadeInputDTO dto);
    HabilidadeOutputDTO buscarPorId(int id);
    List<HabilidadeOutputDTO> listarTodas();
    void deletar(int id);
}

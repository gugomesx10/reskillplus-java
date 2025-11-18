package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.dto.input.PagamentoInputDTO;
import br.com.fiap.reskillplus.dto.output.PagamentoOutputDTO;

import java.util.List;

public interface PagamentoController {

    PagamentoOutputDTO pagar(PagamentoInputDTO dto);

    List<PagamentoOutputDTO> listar();

    PagamentoOutputDTO buscar(Long id);

    PagamentoOutputDTO atualizarStatus(Long id, String status);

    void remover(Long id);
}

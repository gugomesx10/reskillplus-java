package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.service.PagamentoService;
import br.com.fiap.reskillplus.dto.input.PagamentoInputDTO;
import br.com.fiap.reskillplus.dto.output.PagamentoOutputDTO;
import br.com.fiap.reskillplus.mapper.PagamentoMapper;
import jakarta.enterprise.inject.Vetoed;

import java.util.List;

@Vetoed
public class PagamentoControllerImpl implements PagamentoController {

    private final PagamentoService service;
    private final PagamentoMapper mapper;

    public PagamentoControllerImpl(PagamentoService service, PagamentoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public PagamentoOutputDTO pagar(PagamentoInputDTO dto) {
        return mapper.toOutput(
                service.pagar(dto.getCorporacaoId(), dto.getUserId(), dto.getQuantia())
        );
    }

    @Override
    public List<PagamentoOutputDTO> listar() {
        return service.listar().stream().map(mapper::toOutput).toList();
    }

    @Override
    public PagamentoOutputDTO buscar(Long id) {
        return mapper.toOutput(service.buscar(id));
    }

    @Override
    public PagamentoOutputDTO atualizarStatus(Long id, String status) {
        return mapper.toOutput(service.atualizarStatus(id, status));
    }

    @Override
    public void remover(Long id) {
        service.remover(id);
    }
}

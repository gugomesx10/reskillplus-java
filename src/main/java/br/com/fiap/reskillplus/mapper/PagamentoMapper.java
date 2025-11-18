package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.Pagamento;
import br.com.fiap.reskillplus.dto.output.PagamentoOutputDTO;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PagamentoMapper {

    public PagamentoOutputDTO toOutput(Pagamento model) {
        return new PagamentoOutputDTO(
                model.getId(),
                model.getQuantia(),
                model.getStatus(),
                model.getDataCriacao()
        );
    }
}

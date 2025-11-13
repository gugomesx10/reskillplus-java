package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.dto.input.RecomendacaoInputDTO;
import br.com.fiap.reskillplus.dto.output.RecomendacaoOutputDTO;
import br.com.fiap.reskillplus.domain.model.Recomendacao;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RecomendacaoMapper {

    public Recomendacao toModel(RecomendacaoInputDTO dto) {
        if (dto == null) return null;

        return new Recomendacao(
                dto.getCpf_usuario(),
                dto.getNome_curso(),
                dto.getMotivo(),
                dto.getData_recomendacao()
        );
    }

    public RecomendacaoOutputDTO toOutputDTO(Recomendacao model) {
        if (model == null) return null;

        return new RecomendacaoOutputDTO(
                model.getCpf_usuario(),
                model.getNome_curso(),
                model.getMotivo(),
                model.getData_recomendacao()
        );
    }
}

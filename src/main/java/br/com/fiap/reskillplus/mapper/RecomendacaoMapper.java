package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.dto.input.RecomendacaoInputDTO;
import br.com.fiap.reskillplus.dto.output.RecomendacaoOutputDTO;
import java.util.List;
import java.util.stream.Collectors;

public class RecomendacaoMapper {

    public static Recomendacao toEntity(RecomendacaoInputDTO dto) {
        return new Recomendacao(
                0,
                dto.getUsuarioId(),
                dto.getCursoId(),
                dto.getRelevancia(),
                dto.getDataGeracao()
        );
    }

    public static RecomendacaoOutputDTO toOutputDTO(Recomendacao entity) {
        if (entity == null) return null;
        return new RecomendacaoOutputDTO(
                entity.getId(),
                entity.getUsuarioId(),
                entity.getCursoId(),
                entity.getRelevancia(),
                entity.getDataGeracao()
        );
    }

    public static List<RecomendacaoOutputDTO> toOutputList(List<Recomendacao> entities) {
        return entities.stream().map(RecomendacaoMapper::toOutputDTO).collect(Collectors.toList());
    }
}

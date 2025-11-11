package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.dto.input.HabilidadeInputDTO;
import br.com.fiap.reskillplus.dto.output.HabilidadeOutputDTO;
import java.util.List;
import java.util.stream.Collectors;

public class HabilidadeMapper {

    public static Habilidade toEntity(HabilidadeInputDTO dto) {
        return new Habilidade(
                0,
                dto.getNome(),
                dto.getDescricao(),
                dto.getNivel()
        );
    }

    public static HabilidadeOutputDTO toOutputDTO(Habilidade entity) {
        if (entity == null) return null;
        return new HabilidadeOutputDTO(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getNivel()
        );
    }

    public static List<HabilidadeOutputDTO> toOutputList(List<Habilidade> entities) {
        return entities.stream().map(HabilidadeMapper::toOutputDTO).collect(Collectors.toList());
    }
}

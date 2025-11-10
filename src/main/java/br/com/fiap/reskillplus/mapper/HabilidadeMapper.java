package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.dto.input.HabilidadeInputDto;
import br.com.fiap.reskillplus.dto.output.HabilidadeOutputDto;

public class HabilidadeMapper {

    public static Habilidade toEntity(HabilidadeInputDto dto) {
        return new Habilidade(
                null,
                dto.usuarioId,
                dto.nomeHabilidade,
                dto.nivelProficiencia
        );
    }

    public static HabilidadeOutputDto toOutput(Habilidade entity) {
        HabilidadeOutputDto dto = new HabilidadeOutputDto();
        dto.id = entity.getId();
        dto.usuarioId = entity.getUsuarioId();
        dto.nomeHabilidade = entity.getNomeHabilidade();
        dto.nivelProficiencia = entity.getNivelProficiencia();
        return dto;
    }
}

package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.dto.input.RecomendacaoInputDto;
import br.com.fiap.reskillplus.dto.output.RecomendacaoOutputDto;
import java.time.LocalDateTime;

public class RecomendacaoMapper {

    public static Recomendacao toEntity(RecomendacaoInputDto dto) {
        return new Recomendacao(
                null,
                dto.usuarioId,
                dto.cursoId,
                dto.pontuacao,
                LocalDateTime.now()
        );
    }

    public static RecomendacaoOutputDto toOutput(Recomendacao entity) {
        RecomendacaoOutputDto dto = new RecomendacaoOutputDto();
        dto.id = entity.getId();
        dto.usuarioId = entity.getUsuarioId();
        dto.cursoId = entity.getCursoId();
        dto.pontuacao = entity.getPontuacao();
        dto.dataRecomendacao = entity.getDataRecomendacao();
        return dto;
    }
}

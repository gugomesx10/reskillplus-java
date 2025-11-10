package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.Feedback;
import br.com.fiap.reskillplus.dto.input.FeedbackInputDto;
import br.com.fiap.reskillplus.dto.output.FeedbackOutputDto;
import java.time.LocalDateTime;

public class FeedbackMapper {

    public static Feedback toEntity(FeedbackInputDto dto) {
        return new Feedback(
                null,
                dto.usuarioId,
                dto.cursoId,
                dto.avaliacao,
                dto.comentario,
                LocalDateTime.now()
        );
    }

    public static FeedbackOutputDto toOutput(Feedback entity) {
        FeedbackOutputDto dto = new FeedbackOutputDto();
        dto.id = entity.getId();
        dto.usuarioId = entity.getUsuarioId();
        dto.cursoId = entity.getCursoId();
        dto.avaliacao = entity.getAvaliacao();
        dto.comentario = entity.getComentario();
        dto.dataFeedback = entity.getDataFeedback();
        return dto;
    }
}

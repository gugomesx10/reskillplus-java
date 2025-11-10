package br.com.fiap.reskillplus.dto.output;

import java.time.LocalDateTime;

public class FeedbackOutputDto {
    public Long id;
    public Long usuarioId;
    public Long cursoId;
    public Integer avaliacao;
    public String comentario;
    public LocalDateTime dataFeedback;
}

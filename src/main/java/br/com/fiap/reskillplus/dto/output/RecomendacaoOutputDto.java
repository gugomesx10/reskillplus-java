package br.com.fiap.reskillplus.dto.output;

import java.time.LocalDateTime;

public class RecomendacaoOutputDto {
    public Long id;
    public Long usuarioId;
    public Long cursoId;
    public Double pontuacao;
    public LocalDateTime dataRecomendacao;
}

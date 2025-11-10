package br.com.fiap.reskillplus.dto.output;

import java.time.LocalDateTime;

public class MatriculaOutputDto {
    public Long id;
    public Long usuarioId;
    public Long cursoId;
    public LocalDateTime dataMatricula;
    public String status;
    public Integer progresso;
}

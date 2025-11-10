package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.dto.input.MatriculaInputDto;
import br.com.fiap.reskillplus.dto.output.MatriculaOutputDto;
import java.time.LocalDateTime;

public class MatriculaMapper {

    public static Matricula toEntity(MatriculaInputDto dto) {
        return new Matricula(
                null,
                dto.usuarioId,
                dto.cursoId,
                LocalDateTime.now(),
                "ATIVA",
                0
        );
    }

    public static MatriculaOutputDto toOutput(Matricula entity) {
        MatriculaOutputDto dto = new MatriculaOutputDto();
        dto.id = entity.getId();
        dto.usuarioId = entity.getUsuarioId();
        dto.cursoId = entity.getCursoId();
        dto.dataMatricula = entity.getDataMatricula();
        dto.status = entity.getStatus();
        dto.progresso = entity.getProgresso();
        return dto;
    }
}

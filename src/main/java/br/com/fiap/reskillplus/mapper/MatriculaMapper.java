package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.dto.input.MatriculaInputDTO;
import br.com.fiap.reskillplus.dto.output.MatriculaOutputDTO;
import java.util.List;
import java.util.stream.Collectors;

public class MatriculaMapper {

    public static Matricula toEntity(MatriculaInputDTO dto) {
        return new Matricula(
                0,
                dto.getUsuarioId(),
                dto.getCursoId(),
                dto.getDataMatricula(),
                dto.isConcluido()
        );
    }

    public static MatriculaOutputDTO toOutputDTO(Matricula entity) {
        if (entity == null) return null;
        return new MatriculaOutputDTO(
                entity.getId(),
                entity.getUsuarioId(),
                entity.getCursoId(),
                entity.getDataMatricula(),
                entity.isConcluido()
        );
    }

    public static List<MatriculaOutputDTO> toOutputList(List<Matricula> entities) {
        return entities.stream().map(MatriculaMapper::toOutputDTO).collect(Collectors.toList());
    }
}

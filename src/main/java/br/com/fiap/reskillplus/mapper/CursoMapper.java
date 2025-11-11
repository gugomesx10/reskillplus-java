package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.dto.input.CursoInputDTO;
import br.com.fiap.reskillplus.dto.output.CursoOutputDTO;
import java.util.List;
import java.util.stream.Collectors;

public class CursoMapper {

    public static Curso toEntity(CursoInputDTO dto) {
        return new Curso(
                0,
                dto.getTitulo(),
                dto.getDescricao(),
                dto.getCategoria(),
                dto.getCargaHoraria()
        );
    }

    public static CursoOutputDTO toOutputDTO(Curso entity) {
        if (entity == null) return null;
        return new CursoOutputDTO(
                entity.getId(),
                entity.getTitulo(),
                entity.getDescricao(),
                entity.getCategoria(),
                entity.getCargaHoraria()
        );
    }

    public static List<CursoOutputDTO> toOutputList(List<Curso> entities) {
        return entities.stream().map(CursoMapper::toOutputDTO).collect(Collectors.toList());
    }
}

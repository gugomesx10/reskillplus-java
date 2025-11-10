package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.dto.input.CursoInputDto;
import br.com.fiap.reskillplus.dto.output.CursoOutputDto;
import java.time.LocalDateTime;

public class CursoMapper {

    public static Curso toEntity(CursoInputDto dto) {
        return new Curso(null, dto.titulo, dto.descricao, dto.categoria, dto.duracaoHoras, dto.nivel, LocalDateTime.now());
    }

    public static CursoOutputDto toOutput(Curso entity) {
        CursoOutputDto dto = new CursoOutputDto();
        dto.id = entity.getId();
        dto.titulo = entity.getTitulo();
        dto.descricao = entity.getDescricao();
        dto.categoria = entity.getCategoria();
        dto.duracaoHoras = entity.getDuracaoHoras();
        dto.nivel = entity.getNivel();
        dto.dataCriacao = entity.getDataCriacao();
        return dto;
    }
}

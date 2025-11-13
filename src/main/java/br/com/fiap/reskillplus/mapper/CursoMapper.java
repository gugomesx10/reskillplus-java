package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.dto.input.CursoInputDTO;
import br.com.fiap.reskillplus.dto.output.CursoOutputDTO;
import br.com.fiap.reskillplus.domain.model.Curso;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CursoMapper {

    public Curso toModel(CursoInputDTO dto) {
        if (dto == null) return null;

        return new Curso(
                dto.getNome_curso(),
                dto.getDescricao_curso(),
                dto.getCarga_horaria(),
                dto.getCategoria()
        );
    }

    public CursoOutputDTO toOutputDTO(Curso model) {
        if (model == null) return null;

        return new CursoOutputDTO(
                model.getNome_curso(),
                model.getDescricao_curso(),
                model.getCarga_horaria(),
                model.getCategoria()
        );
    }
}

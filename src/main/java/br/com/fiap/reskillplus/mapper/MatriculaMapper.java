package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.dto.input.MatriculaInputDTO;
import br.com.fiap.reskillplus.dto.output.MatriculaOutputDTO;
import br.com.fiap.reskillplus.domain.model.Matricula;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatriculaMapper {

    public Matricula toModel(MatriculaInputDTO dto) {
        if (dto == null) return null;

        return new Matricula(
                dto.getCpf_usuario(),
                dto.getNome_curso(),
                dto.getDt_matricula(),
                dto.getStatus()
        );
    }

    public MatriculaOutputDTO toOutputDTO(Matricula model) {
        if (model == null) return null;

        return new MatriculaOutputDTO(
                model.getCpf_usuario(),
                model.getNome_curso(),
                model.getDt_matricula(),
                model.getStatus()
        );
    }
}

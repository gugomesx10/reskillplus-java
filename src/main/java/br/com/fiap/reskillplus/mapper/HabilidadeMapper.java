package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.dto.input.HabilidadeInputDTO;
import br.com.fiap.reskillplus.dto.output.HabilidadeOutputDTO;
import br.com.fiap.reskillplus.domain.model.Habilidade;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HabilidadeMapper {

    public Habilidade toModel(HabilidadeInputDTO dto) {
        if (dto == null) return null;

        return new Habilidade(
                dto.getNome_habilidade(),
                dto.getDescricao_habilidade(),
                dto.getNivel(),
                dto.getArea()
        );
    }

    public HabilidadeOutputDTO toOutputDTO(Habilidade model) {
        if (model == null) return null;

        return new HabilidadeOutputDTO(
                model.getNome_habilidade(),
                model.getDescricao_habilidade(),
                model.getNivel(),
                model.getArea()
        );
    }
}

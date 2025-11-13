package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.dto.input.UsuarioInputDTO;
import br.com.fiap.reskillplus.dto.output.UsuarioOutputDTO;
import br.com.fiap.reskillplus.domain.model.Usuario;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioMapper {

    public Usuario toModel(UsuarioInputDTO dto) {
        if (dto == null) return null;

        return new Usuario(
                dto.getNome_usuario(),
                dto.getCpf_usuario(),
                dto.getSenha(),
                dto.getDt_nasc(),
                dto.getEnd_usuario(),
                dto.getMail_usuario()
        );
    }

    public UsuarioOutputDTO toOutputDTO(Usuario model) {
        if (model == null) return null;

        return new UsuarioOutputDTO(
                model.getNome_usuario(),
                model.getCpf_usuario(),
                model.getDt_nasc(),
                model.getEnd_usuario(),
                model.getMail_usuario()
        );
    }
}

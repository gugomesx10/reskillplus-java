package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.Usuario;
import br.com.fiap.reskillplus.dto.input.UsuarioInputDTO;
import br.com.fiap.reskillplus.dto.output.UsuarioOutputDTO;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioInputDTO dto) {
        return new Usuario(
                0, // ID gerado pelo banco
                dto.getNome(),
                dto.getEmail(),
                dto.getSenha(),
                dto.getPapel()
        );
    }

    public static UsuarioOutputDTO toOutputDTO(Usuario entity) {
        if (entity == null) return null;
        return new UsuarioOutputDTO(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getPapel()
        );
    }

    public static List<UsuarioOutputDTO> toOutputList(List<Usuario> entities) {
        return entities.stream().map(UsuarioMapper::toOutputDTO).collect(Collectors.toList());
    }
}

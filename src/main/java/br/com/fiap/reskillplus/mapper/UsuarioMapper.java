package br.com.fiap.reskillplus.mapper;

import br.com.fiap.reskillplus.domain.model.Usuario;
import br.com.fiap.reskillplus.dto.input.UsuarioInputDto;
import br.com.fiap.reskillplus.dto.output.UsuarioOutputDto;
import java.time.LocalDateTime;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioInputDto dto) {
        return new Usuario(null, dto.nome, dto.email, dto.senha, dto.nivelEducacao, dto.areasInteresse, LocalDateTime.now());
    }

    public static UsuarioOutputDto toOutput(Usuario entity) {
        UsuarioOutputDto dto = new UsuarioOutputDto();
        dto.id = entity.getId();
        dto.nome = entity.getNome();
        dto.email = entity.getEmail();
        dto.nivelEducacao = entity.getNivelEducacao();
        dto.areasInteresse = entity.getAreasInteresse();
        dto.dataCriacao = entity.getDataCriacao();
        return dto;
    }
}

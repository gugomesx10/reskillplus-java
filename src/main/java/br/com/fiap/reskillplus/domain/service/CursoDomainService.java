package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Curso;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CursoDomainService {

    public boolean validarCurso(Curso curso) {
        return curso.getTitulo() != null &&
                curso.getDescricao() != null &&
                curso.getCargaHoraria() > 0;
    }

    public void atualizarDescricao(Curso curso, String novaDescricao) {
        curso.setDescricao(novaDescricao);
    }

    public void alterarCategoria(Curso curso, String novaCategoria) {
        curso.setCategoria(novaCategoria);
    }
}

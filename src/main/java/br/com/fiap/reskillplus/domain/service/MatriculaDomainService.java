package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Matricula;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Date;

@ApplicationScoped
public class MatriculaDomainService {

    public boolean podeMatricular(Matricula matricula) {
        return matricula.getUsuarioId() > 0 && matricula.getCursoId() > 0;
    }

    public void concluirCurso(Matricula matricula) {
        matricula.setConcluido(true);
    }

    public void atualizarDataMatricula(Matricula matricula) {
        matricula.setDataMatricula(new Date());
    }
}

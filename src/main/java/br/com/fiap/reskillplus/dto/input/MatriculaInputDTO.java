package br.com.fiap.reskillplus.dto.input;

import java.util.Date;

public class MatriculaInputDTO {

    private int usuarioId;
    private int cursoId;
    private Date dataMatricula;
    private boolean concluido;


    public MatriculaInputDTO(int usuarioId, int cursoId, Date dataMatricula, boolean concluido) {
        this.usuarioId = usuarioId;
        this.cursoId = cursoId;
        this.dataMatricula = dataMatricula;
        this.concluido = concluido;
    }

    public int getUsuarioId() { return usuarioId; }
    public int getCursoId() { return cursoId; }
    public Date getDataMatricula() { return dataMatricula; }
    public boolean isConcluido() { return concluido; }

    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
    public void setCursoId(int cursoId) { this.cursoId = cursoId; }
    public void setDataMatricula(Date dataMatricula) { this.dataMatricula = dataMatricula; }
    public void setConcluido(boolean concluido) { this.concluido = concluido; }
}

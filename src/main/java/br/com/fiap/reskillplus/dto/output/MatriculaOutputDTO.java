package br.com.fiap.reskillplus.dto.output;

import java.util.Date;

public class MatriculaOutputDTO {

    private int id;
    private int usuarioId;
    private int cursoId;
    private Date dataMatricula;
    private boolean concluido;

    public MatriculaOutputDTO(int id, int usuarioId, int cursoId, Date dataMatricula, boolean concluido) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.cursoId = cursoId;
        this.dataMatricula = dataMatricula;
        this.concluido = concluido;
    }

    public MatriculaOutputDTO(int id, int usuarioId, int cursoId, String dataMatricula, boolean concluido) {
    }

    public int getId() { return id; }
    public int getUsuarioId() { return usuarioId; }
    public int getCursoId() { return cursoId; }
    public Date getDataMatricula() { return dataMatricula; }
    public boolean isConcluido() { return concluido; }

    public void setId(int id) { this.id = id; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
    public void setCursoId(int cursoId) { this.cursoId = cursoId; }
    public void setDataMatricula(Date dataMatricula) { this.dataMatricula = dataMatricula; }
    public void setConcluido(boolean concluido) { this.concluido = concluido; }
}

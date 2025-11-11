package br.com.fiap.reskillplus.domain.model;

import java.util.Date;

public class Matricula {

    private int id;
    private int usuarioId;
    private int cursoId;
    private Date dataMatricula;
    private boolean concluido;

    public Matricula(int id, int usuarioId, int cursoId, Date dataMatricula, boolean concluido) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.cursoId = cursoId;
        this.dataMatricula = dataMatricula;
        this.concluido = concluido;
    }

    public int getId() {
        return id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}

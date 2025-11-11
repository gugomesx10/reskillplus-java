package br.com.fiap.reskillplus.domain.model;

import java.util.Date;

public class Recomendacao {

    private int id;
    private int usuarioId;
    private int cursoId;
    private double relevancia;
    private Date dataGeracao;

    public Recomendacao(int id, int usuarioId, int cursoId, double relevancia, Date dataGeracao) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.cursoId = cursoId;
        this.relevancia = relevancia;
        this.dataGeracao = dataGeracao;
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

    public double getRelevancia() {
        return relevancia;
    }

    public Date getDataGeracao() {
        return dataGeracao;
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

    public void setRelevancia(double relevancia) {
        this.relevancia = relevancia;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }
}

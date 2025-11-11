package br.com.fiap.reskillplus.dto.input;

import java.util.Date;

public class RecomendacaoInputDTO {

    private int usuarioId;
    private int cursoId;
    private double relevancia;
    private Date dataGeracao;

    public RecomendacaoInputDTO(int usuarioId, int cursoId, double relevancia, Date dataGeracao) {
        this.usuarioId = usuarioId;
        this.cursoId = cursoId;
        this.relevancia = relevancia;
        this.dataGeracao = dataGeracao;
    }

    public int getUsuarioId() { return usuarioId; }
    public int getCursoId() { return cursoId; }
    public double getRelevancia() { return relevancia; }
    public Date getDataGeracao() { return dataGeracao; }

    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
    public void setCursoId(int cursoId) { this.cursoId = cursoId; }
    public void setRelevancia(double relevancia) { this.relevancia = relevancia; }
    public void setDataGeracao(Date dataGeracao) { this.dataGeracao = dataGeracao; }
}

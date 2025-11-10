package br.com.fiap.reskillplus.domain.model;

import java.time.LocalDateTime;

/**
 * Entidade de domínio Recomendacao
 */
public class Recomendacao {
    private Long id;
    private Long usuarioId;
    private Long cursoId;
    private Double pontuacao;
    private LocalDateTime dataRecomendacao;

    public Recomendacao() {}

    public Recomendacao(Long id, Long usuarioId, Long cursoId, Double pontuacao, LocalDateTime dataRecomendacao) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.cursoId = cursoId;
        this.pontuacao = pontuacao;
        this.dataRecomendacao = dataRecomendacao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getCursoId() { return cursoId; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }

    public Double getPontuacao() { return pontuacao; }
    public void setPontuacao(Double pontuacao) { this.pontuacao = pontuacao; }

    public LocalDateTime getDataRecomendacao() { return dataRecomendacao; }
    public void setDataRecomendacao(LocalDateTime dataRecomendacao) { this.dataRecomendacao = dataRecomendacao; }
}

package br.com.fiap.reskillplus.domain.model;

import java.time.LocalDateTime;

/**
 * Entidade de domínio Feedback
 */
public class Feedback {
    private Long id;
    private Long usuarioId;
    private Long cursoId;
    private Integer avaliacao;
    private String comentario;
    private LocalDateTime dataFeedback;

    public Feedback() {}

    public Feedback(Long id, Long usuarioId, Long cursoId, Integer avaliacao,
                    String comentario, LocalDateTime dataFeedback) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.cursoId = cursoId;
        this.avaliacao = avaliacao;
        this.comentario = comentario;
        this.dataFeedback = dataFeedback;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getCursoId() { return cursoId; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }

    public Integer getAvaliacao() { return avaliacao; }
    public void setAvaliacao(Integer avaliacao) { this.avaliacao = avaliacao; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public LocalDateTime getDataFeedback() { return dataFeedback; }
    public void setDataFeedback(LocalDateTime dataFeedback) { this.dataFeedback = dataFeedback; }
}

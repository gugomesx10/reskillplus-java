package br.com.fiap.reskillplus.domain.model;

import java.time.LocalDateTime;

/**
 * Entidade de domínio Matricula
 */
public class Matricula {
    private Long id;
    private Long usuarioId;
    private Long cursoId;
    private LocalDateTime dataMatricula;
    private String status;
    private Integer progresso;

    public Matricula() {}

    public Matricula(Long id, Long usuarioId, Long cursoId, LocalDateTime dataMatricula,
                     String status, Integer progresso) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.cursoId = cursoId;
        this.dataMatricula = dataMatricula;
        this.status = status;
        this.progresso = progresso;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getCursoId() { return cursoId; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }

    public LocalDateTime getDataMatricula() { return dataMatricula; }
    public void setDataMatricula(LocalDateTime dataMatricula) { this.dataMatricula = dataMatricula; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getProgresso() { return progresso; }
    public void setProgresso(Integer progresso) { this.progresso = progresso; }
}

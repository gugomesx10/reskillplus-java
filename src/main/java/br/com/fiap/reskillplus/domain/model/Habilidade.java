package br.com.fiap.reskillplus.domain.model;

public class Habilidade {
    private Long id;
    private Long usuarioId;
    private String nomeHabilidade;
    private Integer nivelProficiencia;

    public Habilidade() {}

    public Habilidade(Long id, Long usuarioId, String nomeHabilidade, Integer nivelProficiencia) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nomeHabilidade = nomeHabilidade;
        this.nivelProficiencia = nivelProficiencia;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getNomeHabilidade() { return nomeHabilidade; }
    public void setNomeHabilidade(String nomeHabilidade) { this.nomeHabilidade = nomeHabilidade; }

    public Integer getNivelProficiencia() { return nivelProficiencia; }
    public void setNivelProficiencia(Integer nivelProficiencia) { this.nivelProficiencia = nivelProficiencia; }
}

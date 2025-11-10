package br.com.fiap.reskillplus.domain.model;

import java.time.LocalDateTime;

/**
 * Entidade de domínio Curso
 */
public class Curso {
    private Long id;
    private String titulo;
    private String descricao;
    private String categoria;
    private Integer duracaoHoras;
    private String nivel;
    private LocalDateTime dataCriacao;

    public Curso() {}

    public Curso(Long id, String titulo, String descricao, String categoria,
                 Integer duracaoHoras, String nivel, LocalDateTime dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.duracaoHoras = duracaoHoras;
        this.nivel = nivel;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Integer getDuracaoHoras() { return duracaoHoras; }
    public void setDuracaoHoras(Integer duracaoHoras) { this.duracaoHoras = duracaoHoras; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}

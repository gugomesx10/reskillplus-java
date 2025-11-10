package br.com.fiap.reskillplus.domain.model;

import java.time.LocalDateTime;

/**
 * Entidade de domínio Usuario
 * Representa um usuário no sistema ReSkill+
 *
 * @author Gustavo Gomes Martins - RM555999
 */
public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String nivelEducacao;
    private String areasInteresse;
    private LocalDateTime dataCriacao;

    // Construtores
    public Usuario() {}

    public Usuario(Long id, String nome, String email, String senha,
                   String nivelEducacao, String areasInteresse, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivelEducacao = nivelEducacao;
        this.areasInteresse = areasInteresse;
        this.dataCriacao = dataCriacao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getNivelEducacao() { return nivelEducacao; }
    public void setNivelEducacao(String nivelEducacao) { this.nivelEducacao = nivelEducacao; }

    public String getAreasInteresse() { return areasInteresse; }
    public void setAreasInteresse(String areasInteresse) { this.areasInteresse = areasInteresse; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}

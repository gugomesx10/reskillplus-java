package br.com.fiap.reskillplus.dto.input;

public class HabilidadeInputDTO {

    private String nome;
    private String descricao;
    private String nivel;

    public HabilidadeInputDTO(String nome, String descricao, String nivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.nivel = nivel;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getNivel() { return nivel; }

    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setNivel(String nivel) { this.nivel = nivel; }
}

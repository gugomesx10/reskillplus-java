package br.com.fiap.reskillplus.dto.output;

public class HabilidadeOutputDTO {

    private int id;
    private String nome;
    private String descricao;
    private String nivel;

    public HabilidadeOutputDTO(int id, String nome, String descricao, String nivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.nivel = nivel;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getNivel() { return nivel; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setNivel(String nivel) { this.nivel = nivel; }
}

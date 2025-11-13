package br.com.fiap.reskillplus.dto.output;

public class HabilidadeOutputDTO {

    private String nome_habilidade;
    private String descricao_habilidade;
    private String nivel;
    private String area;

    public HabilidadeOutputDTO() {}

    public HabilidadeOutputDTO(String nome_habilidade, String descricao_habilidade,
                               String nivel, String area) {
        this.nome_habilidade = nome_habilidade;
        this.descricao_habilidade = descricao_habilidade;
        this.nivel = nivel;
        this.area = area;
    }

    public String getNome_habilidade() { return nome_habilidade; }
    public void setNome_habilidade(String nome_habilidade) { this.nome_habilidade = nome_habilidade; }

    public String getDescricao_habilidade() { return descricao_habilidade; }
    public void setDescricao_habilidade(String descricao_habilidade) { this.descricao_habilidade = descricao_habilidade; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
}

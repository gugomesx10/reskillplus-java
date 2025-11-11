package br.com.fiap.reskillplus.dto.output;

public class CursoOutputDTO {

    private int id;
    private String titulo;
    private String descricao;
    private String categoria;
    private int cargaHoraria;

    public CursoOutputDTO(int id, String titulo, String descricao, String categoria, int cargaHoraria) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.cargaHoraria = cargaHoraria;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getCategoria() { return categoria; }
    public int getCargaHoraria() { return cargaHoraria; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }
}

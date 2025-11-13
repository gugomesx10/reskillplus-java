package br.com.fiap.reskillplus.domain.model;

public class Curso {

    private String nome_curso;
    private String descricao_curso;
    private String carga_horaria;
    private String categoria;

    public Curso() {}

    public Curso(String nome_curso, String descricao_curso, String carga_horaria, String categoria) {
        this.nome_curso = nome_curso;
        this.descricao_curso = descricao_curso;
        this.carga_horaria = carga_horaria;
        this.categoria = categoria;
    }

    public Curso(int idCurso, String nomeCurso, String descricaoCurso) {
    }

    public String getNome_curso() { return nome_curso; }
    public void setNome_curso(String nome_curso) { this.nome_curso = nome_curso; }

    public String getDescricao_curso() { return descricao_curso; }
    public void setDescricao_curso(String descricao_curso) { this.descricao_curso = descricao_curso; }

    public String getCarga_horaria() { return carga_horaria; }
    public void setCarga_horaria(String carga_horaria) { this.carga_horaria = carga_horaria; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}

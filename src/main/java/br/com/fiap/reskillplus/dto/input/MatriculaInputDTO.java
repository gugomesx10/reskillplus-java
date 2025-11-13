package br.com.fiap.reskillplus.dto.input;

public class MatriculaInputDTO {

    private String cpf_usuario;
    private String nome_curso;
    private String dt_matricula;
    private String status;

    public MatriculaInputDTO() {}

    public MatriculaInputDTO(String cpf_usuario, String nome_curso,
                             String dt_matricula, String status) {
        this.cpf_usuario = cpf_usuario;
        this.nome_curso = nome_curso;
        this.dt_matricula = dt_matricula;
        this.status = status;
    }

    public String getCpf_usuario() { return cpf_usuario; }
    public void setCpf_usuario(String cpf_usuario) { this.cpf_usuario = cpf_usuario; }

    public String getNome_curso() { return nome_curso; }
    public void setNome_curso(String nome_curso) { this.nome_curso = nome_curso; }

    public String getDt_matricula() { return dt_matricula; }
    public void setDt_matricula(String dt_matricula) { this.dt_matricula = dt_matricula; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

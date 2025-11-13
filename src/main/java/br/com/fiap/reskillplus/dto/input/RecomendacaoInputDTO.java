package br.com.fiap.reskillplus.dto.input;

public class RecomendacaoInputDTO {

    private String cpf_usuario;
    private String nome_curso;
    private String motivo;
    private String data_recomendacao;

    public RecomendacaoInputDTO() {}

    public RecomendacaoInputDTO(String cpf_usuario, String nome_curso,
                                String motivo, String data_recomendacao) {
        this.cpf_usuario = cpf_usuario;
        this.nome_curso = nome_curso;
        this.motivo = motivo;
        this.data_recomendacao = data_recomendacao;
    }

    public String getCpf_usuario() { return cpf_usuario; }
    public void setCpf_usuario(String cpf_usuario) { this.cpf_usuario = cpf_usuario; }

    public String getNome_curso() { return nome_curso; }
    public void setNome_curso(String nome_curso) { this.nome_curso = nome_curso; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getData_recomendacao() { return data_recomendacao; }
    public void setData_recomendacao(String data_recomendacao) { this.data_recomendacao = data_recomendacao; }
}

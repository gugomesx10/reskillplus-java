package br.com.fiap.reskillplus.dto.input;

public class UsuarioInputDTO {

    private String nome;
    private String email;
    private String senha;
    private String papel;

    public UsuarioInputDTO(String nome, String email, String senha, String papel) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.papel = papel;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public String getPapel() { return papel; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setPapel(String papel) { this.papel = papel; }
}

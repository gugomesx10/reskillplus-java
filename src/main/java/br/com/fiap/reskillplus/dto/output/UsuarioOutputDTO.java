package br.com.fiap.reskillplus.dto.output;

public class UsuarioOutputDTO {

    private int id;
    private String nome;
    private String email;
    private String papel;

    public UsuarioOutputDTO(int id, String nome, String email, String papel) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.papel = papel;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getPapel() { return papel; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setPapel(String papel) { this.papel = papel; }
}

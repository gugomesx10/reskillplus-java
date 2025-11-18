package br.com.fiap.reskillplus.dto.output;

public class AuthOutputDTO {

    private String nome;
    private String email;
    private String avatarUrl;
    private String accessToken;

    public AuthOutputDTO() {}

    public AuthOutputDTO(String nome, String email,
                         String avatarUrl, String accessToken) {
        this.nome = nome;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.accessToken = accessToken;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
}

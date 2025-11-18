package br.com.fiap.reskillplus.domain.model;

public class AuthUsuario {

    private String provider;      // "github", "google", "apple"...
    private String providerId;
    private String nome;
    private String email;
    private String avatarUrl;
    private String accessToken;

    public AuthUsuario() {}

    public AuthUsuario(String provider, String providerId,
                       String nome, String email,
                       String avatarUrl, String accessToken) {
        this.provider = provider;
        this.providerId = providerId;
        this.nome = nome;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.accessToken = accessToken;
    }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public String getProviderId() { return providerId; }
    public void setProviderId(String providerId) { this.providerId = providerId; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
}

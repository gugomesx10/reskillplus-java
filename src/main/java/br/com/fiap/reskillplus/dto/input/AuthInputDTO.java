package br.com.fiap.reskillplus.dto.input;

public class AuthInputDTO {

    private String code;
    private String redirectUri;

    public AuthInputDTO() {}

    public AuthInputDTO(String code, String redirectUri) {
        this.code = code;
        this.redirectUri = redirectUri;
    }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }
}

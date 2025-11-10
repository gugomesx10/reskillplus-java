package br.com.fiap.reskillplus.infrastructure.exceptions;

public class LoginException extends RuntimeException {

    public LoginException() {
        super("Erro de autenticação ou credenciais inválidas.");
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}

package br.com.fiap.reskillplus.infrastructure.exceptions;

public class InfraestruturaException extends RuntimeException {

    public InfraestruturaException() {
        super("Erro interno na infraestrutura da aplicação.");
    }

    public InfraestruturaException(String message) {
        super(message);
    }

    public InfraestruturaException(String message, Throwable cause) {
        super(message, cause);
    }
}

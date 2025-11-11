package br.com.fiap.reskillplus.infrastructure.exceptions;

public class HabilidadeException extends RuntimeException {

    public HabilidadeException(String message) {
        super(message);
    }

    public HabilidadeException(String message, Throwable cause) {
        super(message, cause);
    }
}

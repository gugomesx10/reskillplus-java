package br.com.fiap.reskillplus.infrastructure.exceptions;

public class CursoException extends RuntimeException {

    public CursoException(String message) {
        super(message);
    }

    public CursoException(String message, Throwable cause) {
        super(message, cause);
    }
}

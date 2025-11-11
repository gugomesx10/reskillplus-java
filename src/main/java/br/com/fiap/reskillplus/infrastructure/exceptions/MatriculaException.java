package br.com.fiap.reskillplus.infrastructure.exceptions;

public class MatriculaException extends RuntimeException {

    public MatriculaException(String message) {
        super(message);
    }

    public MatriculaException(String message, Throwable cause) {
        super(message, cause);
    }
}

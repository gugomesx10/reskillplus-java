package br.com.fiap.reskillplus.infrastructure.exceptions;

public class MatriculaException extends RuntimeException {

    public MatriculaException() {
        super("Erro ao processar operação relacionada à Matrícula.");
    }

    public MatriculaException(String message) {
        super(message);
    }

    public MatriculaException(String message, Throwable cause) {
        super(message, cause);
    }
}

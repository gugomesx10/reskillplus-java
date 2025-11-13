package br.com.fiap.reskillplus.application.exceptions;

public class MatriculaJaExisteException extends RuntimeException {
    public MatriculaJaExisteException(String message) {
        super(message);
    }
}

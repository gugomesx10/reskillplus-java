package br.com.fiap.reskillplus.application.exceptions;

public class CursoJaExisteException extends RuntimeException {
    public CursoJaExisteException(String message) {
        super(message);
    }
}

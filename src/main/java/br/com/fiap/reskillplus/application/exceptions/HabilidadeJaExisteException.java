package br.com.fiap.reskillplus.application.exceptions;

public class HabilidadeJaExisteException extends RuntimeException {
    public HabilidadeJaExisteException(String message) {
        super(message);
    }
}

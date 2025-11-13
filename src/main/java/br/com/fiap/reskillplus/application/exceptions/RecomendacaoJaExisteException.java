package br.com.fiap.reskillplus.application.exceptions;

public class RecomendacaoJaExisteException extends RuntimeException {
    public RecomendacaoJaExisteException(String message) {
        super(message);
    }
}

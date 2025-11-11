package br.com.fiap.reskillplus.infrastructure.exceptions;

public class RecomendacaoException extends RuntimeException {

    public RecomendacaoException(String message) {
        super(message);
    }

    public RecomendacaoException(String message, Throwable cause) {
        super(message, cause);
    }
}

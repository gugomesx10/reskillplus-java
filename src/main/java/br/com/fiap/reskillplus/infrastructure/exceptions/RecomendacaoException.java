package br.com.fiap.reskillplus.infrastructure.exceptions;

public class RecomendacaoException extends RuntimeException {

    public RecomendacaoException() {
        super("Erro ao processar operação relacionada à Recomendação.");
    }

    public RecomendacaoException(String message) {
        super(message);
    }

    public RecomendacaoException(String message, Throwable cause) {
        super(message, cause);
    }
}

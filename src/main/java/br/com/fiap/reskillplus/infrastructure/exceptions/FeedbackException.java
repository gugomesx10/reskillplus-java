package br.com.fiap.reskillplus.infrastructure.exceptions;

public class FeedbackException extends RuntimeException {

    public FeedbackException() {
        super("Erro ao processar operação relacionada ao Feedback.");
    }

    public FeedbackException(String message) {
        super(message);
    }

    public FeedbackException(String message, Throwable cause) {
        super(message, cause);
    }
}

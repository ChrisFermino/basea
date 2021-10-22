package br.basea.core.exceptions;

public class MissingParameterException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MissingParameterException(String msg) {
        super(msg);
    }

    public MissingParameterException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
package com.jeremias.dev.renderpoccloud.model.exception;

public class TransactionException extends Exception{

    private static final long serialVersionUID = -5209514676471992053L;

    /**
     * Constructor.
     *
     * @param message the exception message
     */
    public TransactionException(String message) {
        super(message);
    }
}

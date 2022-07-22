package org.bo.junit.app.examples.exception;

public class InsufficientCashException extends RuntimeException {
    public InsufficientCashException(String message) {
        super(message);
    }
}

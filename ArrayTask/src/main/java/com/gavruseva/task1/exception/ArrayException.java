package com.gavruseva.task1.exception;

public class ArrayException extends RuntimeException {
    public ArrayException() {
        super();
    }
    public ArrayException(String message) {
        super(message);
    }
    public ArrayException(String message, Throwable cause) {
        super(message, cause);
    }
    public ArrayException(Throwable cause) {
        super(cause);
    }
}

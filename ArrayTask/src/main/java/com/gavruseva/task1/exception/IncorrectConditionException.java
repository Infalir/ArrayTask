package com.gavruseva.task1.exception;

public class IncorrectConditionException extends Exception {
    public IncorrectConditionException() {
        super();
    }
    public IncorrectConditionException(String message) {
        super(message);
    }
    public IncorrectConditionException(String message, Throwable cause) {
        super(message, cause);
    }
    public IncorrectConditionException(Throwable cause) {
        super(cause);
    }
}

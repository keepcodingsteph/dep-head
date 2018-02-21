package com.ledhead.di;

public class ResolutionConflictException extends Exception {

    public ResolutionConflictException(String message) {
        super(message);
    }

    public ResolutionConflictException(Throwable t) {
        super(t);
    }

    public ResolutionConflictException(String message, Throwable t) {
        super(message, t);
    }
}

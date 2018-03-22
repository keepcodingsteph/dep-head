package com.ledhead.di;

/**
 * Exception for when a requested target type is not resolvable.
 */
public class UnresolvableTypeException extends ResolutionException {

    private Class unresolvableType;

    public UnresolvableTypeException(Class unresolvableType) {
        this.unresolvableType = unresolvableType;
    }
}

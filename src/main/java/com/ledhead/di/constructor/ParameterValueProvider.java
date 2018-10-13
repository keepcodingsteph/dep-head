package com.ledhead.di.constructor;

/**
 * Value provider for parameters being passed to a constructor during instantiation.
 * @param <T> The type of the parameter value.
 */
@FunctionalInterface
public interface ParameterValueProvider<T> {
    /**
     * Provides the value of the parameter.
     * @return
     */
    T getValue();
}

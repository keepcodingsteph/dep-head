package com.ledhead.di.constructor;

/**
 * {@link ParameterValueProvider} that provides an instance of type T.
 *
 * This value provider is useful if the same value should be provided to a constructor every time it is invoked.
 * E.g. if the value provided is read from a configuration file.
 *
 * @param <T>
 */
public class SingleInstanceParameterValueProvider<T> implements ParameterValueProvider<T> {

    private T value;

    /**
     * Creates an instance of the {@link SingleInstanceParameterValueProvider} for provided value instance.
     * @param value the value to be provided by the provider.
     */
    public SingleInstanceParameterValueProvider(T value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getValue() {
        return value;
    }
}

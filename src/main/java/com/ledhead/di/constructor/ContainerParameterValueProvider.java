package com.ledhead.di.constructor;

import com.ledhead.di.Container;

/**
 * Parameter value provider that uses a container to resolve the type.
 *
 * The value provided by invoking {@link Container#resolve(Class, String)} or {@link Container#resolve(Class, String)}.
 *
 * @param <T> the type of the value to be provided.
 */
public class ContainerParameterValueProvider<T> implements ParameterValueProvider<T> {

    private Container container;
    private Class<T> parameterType;
    private String resolutionName;

    /**
     * Creates an instance of the ContainerParameterValueProvider.
     *
     * @param parameterType the type of the parameter value.
     * @param container     the container to use to provide a resolved instance of type T
     */
    public ContainerParameterValueProvider(Class<T> parameterType, Container container) {
        this.parameterType = parameterType;
        this.container = container;
    }

    /**
     * Creates an instance of the ContainerParameterValueProvider.
     *
     * @param parameterType the type of the parameter value.
     * @param container     the container to use to provide a resolved instance of type T
     * @param resolutionName the resolution name to use when invoking {@link Container#resolve(Class, String)}
     */
    public ContainerParameterValueProvider(Class<T> parameterType, Container container, String resolutionName) {
        this(parameterType, container);
        this.resolutionName = resolutionName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getValue() {
        if (resolutionName != null)
            return container.resolve(parameterType, resolutionName);
        else
            return container.resolve(parameterType);
    }
}

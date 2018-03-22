package com.ledhead.di.lifecycle;

import com.ledhead.di.Container;

/**
 * Provides the core functionality of dep-head provided LifecycleManagers.
 * @param <T>
 */
public abstract class BaseLifecycleManager<T> implements LifecycleManager<T> {

    private Container container;

    /**
     * Instantiates a lifecycle manager for a specific container.
     * @param container
     */
    public BaseLifecycleManager(Container container) {
        if(container == null)
            throw new IllegalArgumentException("Cannot instantiate a BaseLifecycleManager without a container.");

        this.container = container;
    }

    /**
     * Retrieves the container for this lifecycle manager.
     * @return
     */
    protected Container getContainer() {
        return container;
    }

    protected T createNewInstance() {

        return null;
    }
}

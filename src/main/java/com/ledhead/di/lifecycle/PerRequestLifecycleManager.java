package com.ledhead.di.lifecycle;

import com.ledhead.di.Container;

public class PerRequestLifecycleManager<T> extends BaseLifecycleManager<T> {

    public PerRequestLifecycleManager(Container container) {
        super(container);
    }

    @Override
    public T getInstance() {
        // FIXME: Implement
        throw new RuntimeException("Not yet implemented");
    }
}

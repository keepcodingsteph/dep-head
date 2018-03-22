package com.ledhead.di.lifecycle;

import com.ledhead.di.Container;

public class PerThreadLifecycleManager<T> extends BaseLifecycleManager<T> {

    public PerThreadLifecycleManager(Container container) {
        super(container);
    }

    @Override
    public T getInstance() {
        // FIXME: Implement
        throw new RuntimeException("Not yet implemented.");
    }
}

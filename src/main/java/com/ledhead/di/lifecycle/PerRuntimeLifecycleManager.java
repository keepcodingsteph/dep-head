package com.ledhead.di.lifecycle;

import com.ledhead.di.Container;

public class PerRuntimeLifecycleManager<T> extends BaseLifecycleManager<T> {

    public PerRuntimeLifecycleManager(Container container) {
        super(container);
    }

    @Override
    public T getInstance( ){
        // FIXME: Implement
        throw new RuntimeException("NOt yet implemented.");
    }
}

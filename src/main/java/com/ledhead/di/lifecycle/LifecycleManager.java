package com.ledhead.di.lifecycle;

/**
 * Interface for classes that manage the lifecycle of objects.
 */
@FunctionalInterface
public interface LifecycleManager<T> {

    /**
     * Returns an instance of the object being managed by the Lifecycle Manager.
     *
     * @return
     */
    T getInstance();

}

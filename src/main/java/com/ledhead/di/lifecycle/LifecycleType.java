package com.ledhead.di.lifecycle;

/**
 * Types of pre-defined types of lifecycles supported by dep-head. These lifecycle types correspond to {@link LifecycleManager}
 * implementations provided by dep-head.
 */
public enum LifecycleType {

    /**
     * Every time you request it, you get a new instance.
     *
     * @see PerRequestLifecycleManager
     */
    PerRequest,

    /**
     * One instance created per container - container scoped singleton.
     *
     * @see PerContainerLifecycleManager
     */
    PerContainer,

    /**
     * One instance per thread.
     *
     * @see PerThreadLifecycleManager
     */
    PerThread,

    /**
     * One instance per runtime - global singleton for the runtime.
     *
     * @see PerRuntimeLifecycleManager
     */
    PerRuntime
}

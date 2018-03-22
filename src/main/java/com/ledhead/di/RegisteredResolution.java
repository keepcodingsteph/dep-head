package com.ledhead.di;

import com.ledhead.di.lifecycle.LifecycleManager;

/**
 * Represents a resolution that is registered with a container with the registered lifecycle manager.
 */
class RegisteredResolution {

    private Resolution resolution;
    private LifecycleManager lifeCycleManager;

    public RegisteredResolution(Resolution resolution, LifecycleManager lifecycleManager) {
        this.resolution = resolution;
        this.lifeCycleManager = lifecycleManager;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public LifecycleManager getLifeCycleManager() {
        return lifeCycleManager;
    }
}

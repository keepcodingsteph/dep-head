package com.ledhead.di;

import com.ledhead.di.lifecycle.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleContainer implements Container {

    protected List<RegisteredResolution> resolutions;
    protected ReentrantLock resolutionsLock;

    public SimpleContainer() {
        resolutions = new ArrayList<>();
        resolutionsLock = new ReentrantLock();
    }

    @Override
    public <T> T resolve(Class<T> type) {
        return null;
    }

    @Override
    public <T> T resolve(Class<T> type, String name) {
        return null;
    }

    @Override
    public <T> void registerType(Class<T> targetType, Class<? extends T> resolutionType) throws ResolutionConflictException {
        resolutionsLock.lock();

        try {
            if(targetType == null)
                throw new IllegalArgumentException("targetType cannot be null.");

            if(resolutionType == null)
                throw new IllegalArgumentException("resolutionType cannot be null.");

            if (resolutions.stream().anyMatch(r -> !r.getResolution().getName().isPresent() && r.getResolution().getTargetType() == targetType))
                throw new ResolutionConflictException("An unnamed resolution of type " + targetType.getName() + " is already registered.");

            resolutions.add(new RegisteredResolution(new Resolution(targetType, resolutionType), new PerRequestLifecycleManager(this)));
        } finally {
            resolutionsLock.unlock();
        }
    }

    @Override
    public <T> void registerType(Class<T> targetType, Class<? extends T> resolutionType, String name) throws ResolutionConflictException {
        resolutionsLock.lock();

        try {
            resolutions.add(new RegisteredResolution(new Resolution(targetType, resolutionType, name), new PerRequestLifecycleManager(this)));
        } finally {
            resolutionsLock.unlock();
        }
    }

    @Override
    public <T> void registerType(Class<T> targetType, Class<? extends T> resolutionType, LifecycleManager<? extends T> lifecycleManager) {
        resolutionsLock.lock();

        try {
            resolutions.add(new RegisteredResolution(new Resolution(targetType, resolutionType), lifecycleManager));
        } finally {
            resolutionsLock.unlock();
        }
    }

    @Override
    public <T> void registerType(Class<T> targetType, Class<? extends T> resolutionType, String name, LifecycleManager<? extends T> lifecycleManager) {
        resolutionsLock.lock();

        try {
            resolutions.add(new RegisteredResolution(new Resolution(targetType, resolutionType, name), lifecycleManager));
        } finally {
            resolutionsLock.unlock();
        }
    }

    @Override
    public <T> void registerType(Class<T> targetType, Class<? extends T> resolutionType, LifecycleType lifecycleType) {
        resolutionsLock.lock();

        try {
            resolutions.add(new RegisteredResolution(new Resolution(targetType, resolutionType), createLifecycleManagerForType(lifecycleType)));
        } finally {
            resolutionsLock.unlock();
        }
    }

    @Override
    public <T> void registerType(Class<T> targetType, Class<? extends T> resolutionType, String name, LifecycleType lifecycleType) {
        resolutionsLock.lock();

        try {
            resolutions.add(new RegisteredResolution(new Resolution(targetType, resolutionType, name), createLifecycleManagerForType(lifecycleType)));
        } finally {
            resolutionsLock.unlock();
        }
    }

    private <T> LifecycleManager<T> createLifecycleManagerForType(LifecycleType lifecycleType) {
        switch (lifecycleType) {
            case PerContainer:
                return new PerContainerLifecycleManager<>(this);
            case PerRuntime:
                return new PerRuntimeLifecycleManager<>(this);
            case PerThread:
                return new PerThreadLifecycleManager<>(this);
            default:
                return new PerRequestLifecycleManager<>(this);
        }
    }
}

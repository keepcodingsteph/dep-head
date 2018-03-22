package com.ledhead.di;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleContainer implements Container {

    List<Resolution> resolutions;
    ReentrantLock resolutionsLock;

    public SimpleContainer() {
        resolutions = new ArrayList<>();
        resolutionsLock = new ReentrantLock();
    }

    @Override
    public <T> T resolve(Class<? extends T> type) {
        return null;
    }

    @Override
    public <T> T resolve(Class<? extends T> type, String name) {
        return null;
    }

    @Override
    public <T> void registerType(Class<T> targetType, Class<? extends T> resolutionType) throws ResolutionConflictException {
        resolutionsLock.lock();

        try {
            resolutions.add(new Resolution(targetType, resolutionType));
        } finally {
            resolutionsLock.unlock();
        }
    }

    @Override
    public <T> void registerType(Class<T> targetType, Class<? extends T> resolutionType, String name) throws ResolutionConflictException {
        resolutionsLock.lock();

        try {
            resolutions.add(new Resolution(targetType, resolutionType, name));
        } finally {
            resolutionsLock.unlock();
        }
    }
}

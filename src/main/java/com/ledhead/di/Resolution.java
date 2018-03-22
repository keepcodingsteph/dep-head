package com.ledhead.di;

import java.util.Optional;

/**
 * Represents a dependency resolution.
 */
class Resolution<T, R extends T> {

    private Class<T> targetType;
    private Class<R> resolutionType;
    private Optional<String> name;

    public Resolution(Class<T> targetType, Class<R> resolutionType) {
        this(targetType, resolutionType, null);
    }

    public Resolution(Class<T> targetType, Class<R> resolutionType, String name) {
        this.targetType = targetType;
        this.resolutionType = resolutionType;
        this.name = Optional.ofNullable(name);
    }

    public Class<T> getTargetType() {
        return targetType;
    }

    public Class<R> getResolutionType() {
        return resolutionType;
    }

    public Optional<String> getName() {
        return name;
    }
}

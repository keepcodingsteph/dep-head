package com.ledhead.di;

/**
 * Interface for a dependency injection container which holds a specified DI context.
 */
public interface Container {

    /**
     * Resolves the type and returns the container resolved instance of type T requested.
     *
     * @param type
     * @param <T>
     * @return
     * @throws ResolutionException if the type cannot be resolved.
     */
    <T> T resolve(Class<? extends T> type) throws ResolutionException;

    /**
     * Resolves the type and returns the container resolved instance of type T with registered name requested. This
     * method will only return a resolution that has the provided name and type.
     *
     * @param type
     * @param name
     * @param <T>
     * @return
     * @throws ResolutionException if the type cannot be resolved by name.
     */
    <T> T resolve(Class<? extends T> type, String name);

    /**
     * Register a type resolution of resolutionType for targetType.
     *
     * @param targetType
     * @param resolutionType
     * @param <T>
     * @throws ResolutionConflictException if an ambiguous resolution for targetType and resolutionType already exists.
     */
    <T> void registerType(Class<T> targetType, Class<? extends T> resolutionType) throws ResolutionConflictException;

    /**
     * Register a type resolution of resolutionType for targetType with the provided name.
     *
     * @param targetType
     * @param resolutionType
     * @param name
     * @param <T>
     * @throws ResolutionConflictException if an ambiguous resolution for targetType and resolutionType already exists.
     */
    <T> void registerType(Class<T> targetType, Class<? extends T> resolutionType, String name) throws ResolutionConflictException;
}

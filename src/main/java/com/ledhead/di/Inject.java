package com.ledhead.di;

import java.lang.annotation.*;

/**
 * Indicates the object should be injected by the container.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@interface Inject {
    /**
     * The name of the named resolution within the injection container that
     * should be used to resolve the type to inject.
     *
     * @return the resolution name
     */
    String name() default "";
}

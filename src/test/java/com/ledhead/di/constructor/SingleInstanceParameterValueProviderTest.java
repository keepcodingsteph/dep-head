package com.ledhead.di.constructor;

import com.ledhead.di.TargetType;
import com.ledhead.di.TargetTypeImplOne;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class SingleInstanceParameterValueProviderTest {

    @Test
    public void nullValue() {
        // Arrange
        SingleInstanceParameterValueProvider<TargetType> provider = new SingleInstanceParameterValueProvider<>(null);

        // Act
        TargetType actualValue = provider.getValue();

        // Assert
        assertNull(actualValue);
    }

    @Test
    public void nonNulValue() {
        // Arrange
        TargetType expectedValue = new TargetTypeImplOne();
        SingleInstanceParameterValueProvider<TargetType> provider = new SingleInstanceParameterValueProvider<>(expectedValue);

        // Act
        TargetType actualValue = provider.getValue();

        // Assert
        assertSame(expectedValue, actualValue);
    }
}

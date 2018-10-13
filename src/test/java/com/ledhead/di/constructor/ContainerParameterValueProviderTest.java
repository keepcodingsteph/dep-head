package com.ledhead.di.constructor;

import com.ledhead.di.Container;
import com.ledhead.di.ResolutionException;
import com.ledhead.di.TargetType;
import com.ledhead.di.TargetTypeImplOne;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ContainerParameterValueProviderTest {

    private Container mockContainer;
    private ContainerParameterValueProvider<TargetType> containerParameterValueProvider;
    private String resolutionName;

    @Before
    public void setup() {
        mockContainer = mock(Container.class);
        resolutionName = UUID.randomUUID().toString();
    }

    @Test(expected = ResolutionException.class)
    public void getValueWithoutNameTypeNotFound()
    {
        // Arrange
        containerParameterValueProvider = new ContainerParameterValueProvider<>(TargetType.class, mockContainer);
        when(mockContainer.resolve(TargetType.class)).thenThrow(ResolutionException.class);

        // Act
        containerParameterValueProvider.getValue();

        // Assert - see expected
    }

    @Test
    public void getValueWithoutNameTypeFound() {
        // Arrange
        containerParameterValueProvider = new ContainerParameterValueProvider<>(TargetType.class, mockContainer);
        when(mockContainer.resolve(TargetType.class)).thenReturn(new TargetTypeImplOne());

        // Act
        TargetType result = containerParameterValueProvider.getValue();

        // Assert - see expected
        assertNotNull(result);
        assertTrue(result instanceof TargetTypeImplOne);
    }

    @Test(expected =  ResolutionException.class)
    public void getValueWIthNameTypeNotFoundTest() {

        // Arrange
        containerParameterValueProvider = new ContainerParameterValueProvider<>(TargetType.class, mockContainer, resolutionName);
        when(mockContainer.resolve(TargetType.class, resolutionName)).thenThrow(ResolutionException.class);

        // Act
        containerParameterValueProvider.getValue();
    }

    @Test
    public void getValueWIthNameTypeFoundTest() {

        // Arrange
        containerParameterValueProvider = new ContainerParameterValueProvider<>(TargetType.class, mockContainer, resolutionName);
        when(mockContainer.resolve(TargetType.class, resolutionName)).thenReturn(new TargetTypeImplOne());

        // Act
        TargetType result = containerParameterValueProvider.getValue();

        // Assert - see expected
        assertNotNull(result);
        assertTrue(result instanceof TargetTypeImplOne);
    }
}

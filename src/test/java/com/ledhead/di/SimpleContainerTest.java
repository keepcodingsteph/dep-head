package com.ledhead.di;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SimpleContainerTest {

    private SimpleContainer container;

    @Before
    public void setup() {
        container = new SimpleContainer();
    }

    /*
     *  registerType(Class<T>, Class<T>)
     */

    @Test(expected = ResolutionConflictException.class)
    public void registerType_TypeAlreadyRegistered() throws ResolutionConflictException {
        container.registerType(TargetType.class, TargetTypeImplOne.class);
        container.registerType(TargetType.class, TargetTypeImplTwo.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void registerType_NullTargetType() throws ResolutionConflictException {
        container.registerType(null, TargetTypeImplOne.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void registerType_NullResolutionType() throws ResolutionConflictException {
        container.registerType(TargetType.class, null);
    }

    @Test
    public void registerType_PositiveTest() throws ResolutionConflictException {
        container.registerType(TargetType.class, TargetTypeImplOne.class);

        assertTrue(container.resolve(TargetType.class) instanceof TargetTypeImplOne);
    }

    /*
     *  registerType(Class<T>, Class<T>, String)
     */

    @Test
    public void registerTypeWithName_TypeAlreadyRegistered() {
        fail("Not yet implemented.");
    }

    @Test
    public void registerTypeWithName_NullTargetType() {
        fail("Not yet implemented.");
    }

    @Test
    public void registerTypeWithName_NullResolutionType() {
        fail("Not yet implemented.");
    }

    @Test
    public void registerTypeWithName_NullName() {
        fail("Not yet implemented.");
    }

    @Test
    public void registerTypeWithName_PositiveTest() {
        fail("Not yet implemented.");
    }
}

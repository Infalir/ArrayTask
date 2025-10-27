package com.gavruseva.task1.builder.implement;

import com.gavruseva.task1.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayBuilderTest {
    private ArrayBuilder arrayBuilder;
    @BeforeEach
    void setUp() {
        arrayBuilder = new ArrayBuilder();
    }
    @Test
    void testCreateIntegerArray(){
        int[] expectedArray = {1, 2, 3, 4, 5};
        int[] actualArray = arrayBuilder.setIntegerArray(1, 2, 3, 4, 5).build().getArray();
        assertArrayEquals(expectedArray, actualArray);
    }
    @Test
    void testThrowsExceptionWhenEmpty(){
        assertThrows(ArrayException.class, () -> arrayBuilder.setIntegerArray());
    }
}
package com.gavruseva.task1.creator.implement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCreatorTest {
    private ArrayCreator arrayCreator;
    @BeforeEach
    void setUp() {
        arrayCreator = new ArrayCreator();
    }
    @Test
    void testCreateArray() {
        int[] expectedArray = {2, 46, 8, 3, 1, 0};
        int[] actualArray = arrayCreator.createCustomArray("src/test/resources/array.txt").getArray();
        assertArrayEquals(expectedArray, actualArray);
    }
}
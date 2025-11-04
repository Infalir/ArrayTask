package main.com.gavruseva.task1.builder.impl;

import main.com.gavruseva.task1.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayBuilderImplTest {
    private ArrayBuilderImpl arrayBuilderImpl;
    @BeforeEach
    public void setUp() {
        arrayBuilderImpl = new ArrayBuilderImpl();
    }
    @Test
    public void testCreateIntegerArray() throws ArrayException {
        int[] expectedArray = {1, 2, 3, 4, 5};
        int[] actualArray = arrayBuilderImpl.setIntegerArray(1, 2, 3, 4, 5).build().getArray();
        assertArrayEquals(expectedArray, actualArray);
    }
    @Test
    public void testThrowsExceptionWhenEmpty(){
        assertThrows(ArrayException.class, () -> arrayBuilderImpl.setIntegerArray());
    }
}
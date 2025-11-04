package main.com.gavruseva.task1.entity;

import main.com.gavruseva.task1.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayTest {
    private int[] array;
    private int id;
    private CustomArray customArray;

    @BeforeEach
    public void setUp() {
        array = new int[] { 1, 2, 3, 4 };
        id = 1;
    }

    @Test
    public void testCreation() throws ArrayException {
        customArray = new CustomArray(array, id);
        assertNotNull(customArray);
    }

    @Test
    public void testGetArray() throws ArrayException {
        customArray = new CustomArray(array, id);
        int[] expectedArray = { 1, 2, 3, 4 };
        assertArrayEquals(expectedArray, customArray.getArray());
    }

    @Test
    public void testSetArray() throws ArrayException {
        customArray = new CustomArray(array, id);
        int[] temp = {0, 0, 0};
        customArray.setArray(temp);
        assertArrayEquals(temp, customArray.getArray());
    }

    @Test
    public void testGetIndex() throws ArrayException {
        customArray = new CustomArray(array, id);
        int expectedId = 1;
        assertEquals(expectedId, customArray.getId());
    }
}
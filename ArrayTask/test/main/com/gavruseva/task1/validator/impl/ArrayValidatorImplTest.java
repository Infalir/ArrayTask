package main.com.gavruseva.task1.validator.impl;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayValidatorImplTest {
    private ArrayValidatorImpl arrayValidator;

    @BeforeEach
    public void setUp() {
        arrayValidator = new ArrayValidatorImpl();
    }

    @Test
    public void testArrayValid() throws ArrayException {
        int[] tempArray = {0,1,2};
        CustomArray customArray = new CustomArray(tempArray, 0);
        assertTrue(arrayValidator.isArrayValid(customArray));
    }

    @Test
    public void testArrayInvalid() throws ArrayException {
        int[] tempArray = {0,1,2};
        CustomArray customArray = new CustomArray(tempArray, -3456);
        assertFalse(arrayValidator.isArrayValid(customArray));

    }

}
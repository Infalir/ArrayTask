package com.gavruseva.task1.service.impl;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayCalculateImplTest {
    private CustomArray array;
    private ArrayCalculateImpl calculator;

    @BeforeEach
    public void setUp() throws ArrayException{
        int[] tempArray = {7, 3, -1, 0, 18, -3};
        array = new CustomArray(tempArray, 0);
        calculator = new ArrayCalculateImpl();
    }

    @Test
    public void testFindMin() throws ArrayException {
        int expectedResult = -3;
        int actualResult = calculator.findMin(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindMax()throws ArrayException{
        int expectedResult = 18;
        int actualResult = calculator.findMax(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindSum()throws ArrayException{
        int expectedResult = 24;
        int actualResult = calculator.findSum(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindAvg()throws ArrayException{
        double expectedResult = 24.0/6.0;
        double actualResult = calculator.findAvg(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindPositiveAmount()throws ArrayException{
        int expectedResult = 3;
        int actualResult = calculator.findPositiveAmount(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testFindNegativeAmount()throws ArrayException{
        int expectedResult = 2;
        int actualResult = calculator.findNegativeAmount(array);
        assertEquals(expectedResult, actualResult);
    }
}
package com.gavruseva.task1.service.implement;

import com.gavruseva.task1.entity.CustomArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStreamCalculateTest {
    private CustomArray array;
    private ArrayStreamCalculate calculator;

    @BeforeEach
    void setUp() {
        array = new CustomArray(7, 3, -1, 0, 18, -3);
        calculator = new ArrayStreamCalculate();
    }

    @Test
    void testFindMin(){
        int expectedResult = -3;
        int actualResult = calculator.findMin(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testFindMax(){
        int expectedResult = 18;
        int actualResult = calculator.findMax(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testFindSum(){
        int expectedResult = 24;
        int actualResult = calculator.findSum(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testFindAvg(){
        double expectedResult = 24.0/6.0;
        double actualResult = calculator.findAvg(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testFindPositiveAmount(){
        int expectedResult = 3;
        int actualResult = calculator.findPositiveAmount(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testFindNegativeAmount(){
        int expectedResult = 2;
        int actualResult = calculator.findNegativeAmount(array);
        assertEquals(expectedResult, actualResult);
    }
}
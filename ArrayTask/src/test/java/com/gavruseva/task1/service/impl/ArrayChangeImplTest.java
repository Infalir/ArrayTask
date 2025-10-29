package com.gavruseva.task1.service.impl;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.exception.IncorrectConditionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayChangeImplTest {
    private CustomArray array;
    private ArrayChangeImpl changer;

    @BeforeEach
    void setUp() throws ArrayException{
        int[] tempArray = {7, 3, -1, 0, 18, -3};
        array = new CustomArray(tempArray, 0);
        changer = new ArrayChangeImpl();
    }

    @Test
    void testLessThan() throws IncorrectConditionException, ArrayException {
        changer.changeElements(array, " < ", 3, 0);
        int[] resultArray = {7, 3, 0, 0, 18, 0};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    void testGreaterThan() throws IncorrectConditionException, ArrayException{
        changer.changeElements(array, "> ", 3, 0);
        int[] resultArray = {0, 3, -1, 0, 0, -3};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    void testEqualsTo() throws IncorrectConditionException, ArrayException{
        changer.changeElements(array, " = ", 3, 999);
        int[] resultArray = {7, 999, -1, 0, 18, -3};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    void testGreaterOrEqualsTo() throws IncorrectConditionException, ArrayException{
        changer.changeElements(array, " >= ", 3, 0);
        int[] resultArray = {0, 0, -1, 0, 0, -3};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    void testLessOrEqualsTo() throws IncorrectConditionException, ArrayException{
        changer.changeElements(array, " <= ", 3, 0);
        int[] resultArray = {7, 0, 0, 0, 18, 0};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    void testDoesNotEqualTo() throws IncorrectConditionException, ArrayException{
        changer.changeElements(array, " != ", 3, 999);
        int[] resultArray = {999, 3, 999, 999, 999, 999};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    void testDefault(){
        assertThrows(IncorrectConditionException.class, () ->
                changer.changeElements(array, "dfghk", 3, 0));
    }

}
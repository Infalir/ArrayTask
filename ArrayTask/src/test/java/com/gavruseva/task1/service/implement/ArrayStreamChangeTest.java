package com.gavruseva.task1.service.implement;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.exception.IncorrectConditionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStreamChangeTest {
    private CustomArray array;
    private ArrayStreamChange changer;

    @BeforeEach
    void setUp() {
        array = new CustomArray(7, 3, -1, 0, 18, -3);
        changer = new ArrayStreamChange();
    }

    @Test
    void testLessThan(){
        changer.changeElements(array, " < ", 3, 0);
        int[] resultArray = {7, 3, 0, 0, 18, 0};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    void testGreaterThan(){
        changer.changeElements(array, "> ", 3, 0);
        int[] resultArray = {0, 3, -1, 0, 0, -3};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    void testEqualsTo(){
        changer.changeElements(array, " = ", 3, 999);
        int[] resultArray = {7, 999, -1, 0, 18, -3};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    void testGreaterOrEqualsTo(){
        changer.changeElements(array, " >= ", 3, 0);
        int[] resultArray = {0, 0, -1, 0, 0, -3};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    void testLessOrEqualsTo(){
        changer.changeElements(array, " <= ", 3, 0);
        int[] resultArray = {7, 0, 0, 0, 18, 0};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    void testDoesNotEqualTo(){
        changer.changeElements(array, " != ", 3, 999);
        int[] resultArray = {999, 3, 999, 999, 999, 999};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    void testInvalidCondition(){
        assertThrows(IncorrectConditionException.class, () ->
                changer.changeElements(array, "dfghk", 3, 0));
    }
    @Test
    void testEmptyArray(){
        assertThrows(ArrayException.class, () ->
                changer.changeElements(null, "=", 3, 0));
    }
}
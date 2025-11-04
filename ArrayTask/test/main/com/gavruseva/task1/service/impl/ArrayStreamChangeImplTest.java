package main.com.gavruseva.task1.service.impl;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import main.com.gavruseva.task1.exception.IncorrectConditionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStreamChangeImplTest {
    private CustomArray array;
    private ArrayStreamChangeImpl changer;

    @BeforeEach
    public void setUp() throws ArrayException{
        int[] tempArray = {7, 3, -1, 0, 18, -3};
        array = new CustomArray(tempArray, 0);
        changer = new ArrayStreamChangeImpl();
    }

    @Test
    public void testLessThan() throws IncorrectConditionException, ArrayException {
        changer.changeElements(array, " < ", 3, 0);
        int[] resultArray = {7, 3, 0, 0, 18, 0};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    public void testGreaterThan() throws IncorrectConditionException, ArrayException{
        changer.changeElements(array, "> ", 3, 0);
        int[] resultArray = {0, 3, -1, 0, 0, -3};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    public void testEqualsTo() throws IncorrectConditionException, ArrayException{
        changer.changeElements(array, " = ", 3, 999);
        int[] resultArray = {7, 999, -1, 0, 18, -3};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    public void testGreaterOrEqualsTo() throws IncorrectConditionException, ArrayException{
        changer.changeElements(array, " >= ", 3, 0);
        int[] resultArray = {0, 0, -1, 0, 0, -3};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    public void testLessOrEqualsTo() throws IncorrectConditionException, ArrayException{
        changer.changeElements(array, " <= ", 3, 0);
        int[] resultArray = {7, 0, 0, 0, 18, 0};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    public void testDoesNotEqualTo() throws IncorrectConditionException, ArrayException{
        changer.changeElements(array, " != ", 3, 999);
        int[] resultArray = {999, 3, 999, 999, 999, 999};
        assertArrayEquals(resultArray, array.getArray());
    }

    @Test
    public void testInvalidCondition(){
        assertThrows(IncorrectConditionException.class, () ->
                changer.changeElements(array, "dfghk", 3, 0));
    }
    @Test
    public void testEmptyArray(){
        assertThrows(ArrayException.class, () ->
                changer.changeElements(null, "=", 3, 0));
    }
}
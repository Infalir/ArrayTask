package com.gavruseva.task1.service.impl;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySortImplTest {
    private CustomArray array;
    private final int[] expectedArray = {-3, -1, 0, 3, 7, 18};
    private ArraySortImpl sorter;

    @BeforeEach
    public void setUp() throws ArrayException{
        int[] tempArray = {7, 3, -1, 0, 18, -3};
        array = new CustomArray(tempArray, 0);
        sorter = new ArraySortImpl();
    }

    @Test
    public void testBubbleSort() throws ArrayException {
        sorter.bubbleSort(array);
        int[] actualArray = array.getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testSelectionSort()throws ArrayException{
        sorter.selectionSort(array);
        int[] actualArray = array.getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testInsertionSort()throws ArrayException{
        sorter.insertionSort(array);
        int[] actualArray = array.getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

}
package com.gavruseva.task1.service.impl;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStreamSortImplTest {
    private CustomArray array;
    private final int[] expectedArray = {-3, -1, 0, 3, 7, 18};
    private ArrayStreamSortImpl sorter;

    @BeforeEach
    void setUp() throws ArrayException {
        int[] tempArray = {7, 3, -1, 0, 18, -3};
        array = new CustomArray(tempArray, 0);
        sorter = new ArrayStreamSortImpl();
    }

    @Test
    void testBubbleSort()throws ArrayException{
        sorter.bubbleSort(array);
        int[] actualArray = array.getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void testSelectionSort()throws ArrayException{
        sorter.selectionSort(array);
        int[] actualArray = array.getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void testInsertionSort()throws ArrayException{
        sorter.insertionSort(array);
        int[] actualArray = array.getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

}
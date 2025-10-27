package com.gavruseva.task1.service.implement;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortTest {
    private CustomArray array;
    private final int[] expectedArray = {-3, -1, 0, 3, 7, 18};
    private ArraySort sorter;

    @BeforeEach
    void setUp() {
        array = new CustomArray(7, 3, -1, 0, 18, -3);
        sorter = new ArraySort();
    }

    @Test
    void testBubbleSort(){
        sorter.bubbleSort(array);
        int[] actualArray = array.getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void testSelectionSort(){
        sorter.selectionSort(array);
        int[] actualArray = array.getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void testInsertionSort(){
        sorter.insertionSort(array);
        int[] actualArray = array.getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

}
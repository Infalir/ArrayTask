package com.gavruseva.task1.repository.impl;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.repository.ArrayRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRepositoryImplTest {
    private ArrayRepository repository;
    private CustomArray array;
    @BeforeEach
    void setUp() throws ArrayException{
        repository = ArrayRepositoryImpl.getInstance();
        int[] tempArray = {7, 3, -1, 0, 18, -3};
        array = new CustomArray(tempArray, 0);
    }

    @Test
    void testAddArray() throws ArrayException {
        repository.addArray(array);
        int[] expectedArray = {7, 3, -1, 0, 18, -3};
        int[] actualArray = repository.getArrayById(0).getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

}
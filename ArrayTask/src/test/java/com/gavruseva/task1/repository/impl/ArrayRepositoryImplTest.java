package com.gavruseva.task1.repository.impl;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.queries.IdSpecification;
import com.gavruseva.task1.queries.LengthBetweenSpecification;
import com.gavruseva.task1.queries.Specification;
import com.gavruseva.task1.queries.SumGreaterThanSpecification;
import com.gavruseva.task1.repository.*;
import com.gavruseva.task1.sorter.ArrayComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayRepositoryImplTest {
    private ArrayRepository repository;
    private Specification specification;
    private CustomArray temp, temp1, temp2;
    @BeforeEach
    public void setUp() throws ArrayException{
        repository = ArrayRepositoryImpl.getInstance();
        int[] tempArray = {7, 3, -1, 0, 18, -3};
        int[] tempArray1 = {0, 0};
        int[] tempArray2 = {2, 9, 10, 18};
        temp = new CustomArray(tempArray, 9);
        temp1 = new CustomArray(tempArray1, 12);
        temp2 = new CustomArray(tempArray2, 3);
    }

    @Test
    public void testAddArray() throws ArrayException {
        repository.addArray(temp1);
        specification = new IdSpecification(12);
        int[] actualArray = repository.query(specification).getFirst().getArray();
        assertArrayEquals(temp1.getArray(), actualArray);
    }

    @Test
    public void testRemoveArray() throws ArrayException {
        repository.addArray(temp1);
        assertTrue(repository.removeArray(0));
    }

    @Test
    public void testIdSpecification() throws ArrayException {
        repository.addArray(temp);
        repository.addArray(temp1);
        repository.addArray(temp2);
        specification = new IdSpecification(12);
        int[] expectedArray = {0, 0};
        int[] actualArray = repository.query(specification).getFirst().getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testLengthBetweenSpecification() throws ArrayException {
        repository.addArray(temp);
        repository.addArray(temp1);
        repository.addArray(temp2);
        specification = new LengthBetweenSpecification(3, 5);
        int[] expectedArray = {2, 9, 10, 18};
        int[] actualArray = repository.query(specification).getFirst().getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testSumGreaterThanSpecification() throws ArrayException {
        repository.addArray(temp);
        repository.addArray(temp1);
        repository.addArray(temp2);
        specification = new SumGreaterThanSpecification(25);
        int[] expectedArray = {2, 9, 10, 18};
        int[] actualArray = repository.query(specification).getFirst().getArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testIdComparator() throws ArrayException {
        repository.addArray(temp);
        repository.addArray(temp1);
        repository.addArray(temp2);
        List<CustomArray> sortedRepository = repository.sortArray(ArrayComparator.ID);
        List<CustomArray> expectedRepository = Arrays.asList(temp2, temp, temp1);
        assertTrue(expectedRepository.containsAll(sortedRepository));
    }

    @Test
    public void testLengthComparator() throws ArrayException {
        repository.addArray(temp);
        repository.addArray(temp1);
        repository.addArray(temp2);
        List<CustomArray> sortedRepository = repository.sortArray(ArrayComparator.LENGTH);
        List<CustomArray> expectedRepository = Arrays.asList(temp1, temp2, temp);
        assertTrue(expectedRepository.containsAll(sortedRepository));
    }

    @Test
    public void testFirstElementComparator() throws ArrayException {
        repository.addArray(temp);
        repository.addArray(temp1);
        repository.addArray(temp2);
        List<CustomArray> sortedRepository = repository.sortArray(ArrayComparator.FIRST_ELEMENT);
        List<CustomArray> expectedRepository = Arrays.asList(temp1, temp2, temp);
        assertTrue(expectedRepository.containsAll(sortedRepository));
    }

}
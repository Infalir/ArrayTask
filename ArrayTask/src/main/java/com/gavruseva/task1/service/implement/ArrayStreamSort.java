package com.gavruseva.task1.service.implement;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.service.interfaces.ArraySortInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayStreamSort implements ArraySortInterface {
    private final static Logger logger = LogManager.getLogger();
    @Override
    public void bubbleSort(CustomArray array) {
        logger.info("Method for bubble sorting as stream is called");
        int[] sortedArray = Arrays.stream(array.getArray()).sorted().toArray();
        array.setArray(sortedArray);
    }
    @Override
    public void insertionSort(CustomArray array) {
        logger.info("Method for insertion sorting as stream is called");
        int[] sortedArray = Arrays.stream(array.getArray()).sorted().toArray();
        array.setArray(sortedArray);
    }
    @Override
    public void selectionSort(CustomArray array) {
        logger.info("Method for selection sorting as stream is called");
        int[] sortedArray = Arrays.stream(array.getArray()).sorted().toArray();
        array.setArray(sortedArray);
    }
}

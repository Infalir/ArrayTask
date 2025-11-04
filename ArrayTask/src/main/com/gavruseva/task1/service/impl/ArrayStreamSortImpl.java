package main.com.gavruseva.task1.service.impl;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import main.com.gavruseva.task1.service.ArraySort;
import main.com.gavruseva.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayStreamSortImpl implements ArraySort {
    private final static Logger logger = LogManager.getLogger();
    private final ArrayValidatorImpl arrayValidator = new ArrayValidatorImpl();
    @Override
    public void bubbleSort(CustomArray array) throws ArrayException {
        logger.info("Method for bubble sorting as stream is called");
        if (!arrayValidator.isArrayValid(array)) {
            logger.error("Array is not valid for bubble sorting elements using stream");
            throw new ArrayException("Array is null or empty");
        }
        int[] sortedArray = Arrays.stream(array.getArray()).sorted().toArray();
        array.setArray(sortedArray);
    }
    @Override
    public void insertionSort(CustomArray array) throws ArrayException{
        logger.info("Method for insertion sorting as stream is called");
        if (!arrayValidator.isArrayValid(array)) {
            logger.error("Array is not valid for insertion sorting elements using stream");
            throw new ArrayException("Array is null or empty");
        }
        int[] sortedArray = Arrays.stream(array.getArray()).sorted().toArray();
        array.setArray(sortedArray);
    }
    @Override
    public void selectionSort(CustomArray array) throws ArrayException{
        logger.info("Method for selection sorting as stream is called");
        if (!arrayValidator.isArrayValid(array)) {
            logger.error("Array is not valid for selection sorting elements using stream");
            throw new ArrayException("Array is null or empty");
        }
        int[] sortedArray = Arrays.stream(array.getArray()).sorted().toArray();
        array.setArray(sortedArray);
    }
}

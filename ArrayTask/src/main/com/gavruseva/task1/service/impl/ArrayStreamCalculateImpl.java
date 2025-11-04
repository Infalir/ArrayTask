package main.com.gavruseva.task1.service.impl;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import main.com.gavruseva.task1.service.ArrayCalculate;
import main.com.gavruseva.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayStreamCalculateImpl implements ArrayCalculate {
    private final static Logger logger = LogManager.getLogger();
    private final ArrayValidatorImpl arrayValidator = new ArrayValidatorImpl();

    @Override
    public int findMin(CustomArray array) throws ArrayException {
        logger.info("Finding a minimum element using stream");
        int min = Arrays.stream(array.getArray()).min().orElseThrow(ArrayException::new);
        return min;
    }

    @Override
    public int findMax(CustomArray array) throws ArrayException {
        int max = Arrays.stream(array.getArray()).max().orElseThrow(ArrayException::new);
        return max;
    }

    @Override
    public int findSum(CustomArray array) throws ArrayException {
        logger.info("Finding a sum of elements using stream");
        if(!arrayValidator.isArrayValid(array)) {
            logger.error("Array is not valid for finding a sum of elements using stream");
            throw new ArrayException("Can't work with an invalid array valid");
        }
        int sum = Arrays.stream(array.getArray()).sum();
        return sum;
    }

    @Override
    public double findAvg(CustomArray array) throws ArrayException {
        double average = Arrays.stream(array.getArray()).average().orElseThrow(ArrayException::new);
        return average;
    }

    @Override
    public int findPositiveAmount(CustomArray array) throws ArrayException {
        logger.info("Finding the amount of positive elements using stream");
        if(!arrayValidator.isArrayValid(array)) {
            logger.error("Array is not valid for finding the amount of positive elements using stream");
            throw new ArrayException("Can't work with an invalid array valid");
        }
        int quantity = (int) Arrays.stream(array.getArray()).filter(s -> s > 0).count();
        return quantity;
    }

    @Override
    public int findNegativeAmount(CustomArray array) throws ArrayException {
        logger.info("Finding the amount of negative elements using stream");
        if(!arrayValidator.isArrayValid(array)) {
            logger.error("Array is not valid for finding the amount of negative elements using stream");
            throw new ArrayException("Can't work with an invalid array valid");
        }
        int quantity = (int) Arrays.stream(array.getArray()).filter(s -> s < 0).count();
        return quantity;
    }
}

package main.com.gavruseva.task1.service.impl;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import main.com.gavruseva.task1.service.ArrayCalculate;
import main.com.gavruseva.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCalculateImpl implements ArrayCalculate {
    private final static Logger logger = LogManager.getLogger();
    private final ArraySortImpl sorter = new ArraySortImpl();
    private final ArrayValidatorImpl arrayValidator = new ArrayValidatorImpl();

    @Override
    public int findMin(CustomArray array) throws ArrayException {
        logger.info("Method for finding the minimum element is called");
        sorter.bubbleSort(array);
        int min = array.getArray()[0];
        return min;
    }

    @Override
    public int findMax(CustomArray array) throws ArrayException{
        logger.info("Method for finding the maximum element is called");
        sorter.bubbleSort(array);
        int index = array.getArray().length - 1;
        int max = array.getArray()[index];
        return max;
    }

    @Override
    public int findSum(CustomArray array) throws ArrayException{
        logger.info("Method for finding the sum of elements is called");
        if(!arrayValidator.isArrayValid(array)) {
            logger.error("Array is not valid for finding a sum");
            throw new ArrayException("Can't work with an invalid array valid");
        }
        int sum = 0;
        int[] tempArray =  array.getArray();
        for (int el: tempArray) {
            sum += el;
        }
        return sum;
    }

    @Override
    public double findAvg(CustomArray array) throws ArrayException{
        logger.info("Method for finding the average element is called");
        if(!arrayValidator.isArrayValid(array)) {
            logger.error("Array is not valid for finding an average element");
            throw new ArrayException("Can't work with an invalid array valid");
        }
        long sum = 0;
        int[] tempArray =  array.getArray();
        for (int el: tempArray) {
            sum += el;
        }
        int amount = tempArray.length;
        double average = sum * 1.0 / amount;
        return average;
    }

    @Override
    public int findPositiveAmount(CustomArray array) throws ArrayException{
        logger.info("Method for finding the amount of positive element is called");
        if(!arrayValidator.isArrayValid(array)) {
            logger.error("Array is not valid for finding amount of positive elements");
            throw new ArrayException("Can't work with an invalid array valid");
        }
        int count = 0;
        int[] tempArray =  array.getArray();
        for (int el: tempArray) {
            if(el > 0){
                count++;
            }
        }
        return count;
    }

    @Override
    public int findNegativeAmount(CustomArray array) throws ArrayException{
        logger.info("Method for finding the amount of negative element is called");
        if(!arrayValidator.isArrayValid(array)) {
            logger.error("Array is not valid for finding amount of negative elements");
            throw new ArrayException("Can't work with an invalid array valid");
        }
        int count = 0;
        int[] tempArray =  array.getArray();
        for (int el: tempArray) {
            if(el < 0){
                count++;
            }
        }
        return count;
    }
}

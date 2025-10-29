package com.gavruseva.task1.service.impl;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.service.ArrayCalculate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayStreamCalculateImpl implements ArrayCalculate {
    private final static Logger logger = LogManager.getLogger();
    @Override
    public int findMin(CustomArray entity) throws ArrayException {
        int min = Arrays.stream(entity.getArray()).min().orElseThrow(ArrayException::new);
        return min;
    }

    @Override
    public int findMax(CustomArray entity) throws ArrayException {
        int max = Arrays.stream(entity.getArray()).max().orElseThrow(ArrayException::new);
        return max;
    }

    @Override
    public int findSum(CustomArray entity) throws ArrayException {
        int sum = Arrays.stream(entity.getArray()).sum();
        return sum;
    }

    @Override
    public double findAvg(CustomArray entity) throws ArrayException {
        double average = Arrays.stream(entity.getArray()).average().orElseThrow(ArrayException::new);
        return average;
    }

    @Override
    public int findPositiveAmount(CustomArray entity) throws ArrayException {
        int quantity = (int) Arrays.stream(entity.getArray()).filter(s -> s > 0).count();
        return quantity;
    }

    @Override
    public int findNegativeAmount(CustomArray entity) throws ArrayException {
        int quantity = (int) Arrays.stream(entity.getArray()).filter(s -> s < 0).count();
        return quantity;
    }
}

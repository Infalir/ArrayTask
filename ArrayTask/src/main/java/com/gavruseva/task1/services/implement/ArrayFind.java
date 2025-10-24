package com.gavruseva.task1.services.implement;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.services.ArrayFindInterface;
import com.gavruseva.task1.validators.implement.ArrayValidator;

public class ArrayFind implements ArrayFindInterface {
    private final ArrayValidator validator = new ArrayValidator();
    private final ArraySort sorter = new ArraySort();
    @Override
    public int findMin(CustomArray array) throws ArrayException {
        if(!validator.isValid(array)){
            throw new ArrayException("Array is not valid");
        }
        sorter.bubbleSort(array);
        int min = array.getArray()[0];
        return min;
    }
    @Override
    public int findMax(CustomArray array) throws ArrayException {
        if(!validator.isValid(array)){
            throw new ArrayException("Array is not valid");
        }
        sorter.bubbleSort(array);
        int index = array.getArray().length - 1;
        int max = array.getArray()[index];
        return max;
    }
    @Override
    public int findSum(CustomArray array) throws ArrayException {
        if(!validator.isValid(array)){
            throw new ArrayException("Array is not valid");
        }
        int sum = 0;
        int[] tempArray =  array.getArray();
        for (int el: tempArray) {
            sum += el;
        }
        return sum;
    }
    @Override
    public double findAvg(CustomArray array) throws ArrayException {
        if(!validator.isValid(array)){
            throw new ArrayException("Array is not valid");
        }
        double sum = 0;
        int[] tempArray =  array.getArray();
        for (int el: tempArray) {
            sum += el;
        }
        int amount = tempArray.length;
        return sum/amount;
    }
    @Override
    public int findPositiveAmount(CustomArray array) throws ArrayException {
        if(!validator.isValid(array)){
            throw new ArrayException("Array is not valid");
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
    public int findNegativeAmount(CustomArray array) throws ArrayException {
        if(!validator.isValid(array)){
            throw new ArrayException("Array is not valid");
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

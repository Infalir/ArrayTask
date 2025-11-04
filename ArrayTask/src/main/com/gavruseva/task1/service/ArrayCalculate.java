package main.com.gavruseva.task1.service;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;

public interface ArrayCalculate {
    int findMin(CustomArray array) throws ArrayException;
    int findMax(CustomArray array) throws ArrayException;
    int findSum(CustomArray array) throws ArrayException;
    double findAvg(CustomArray array) throws ArrayException;
    int findPositiveAmount(CustomArray array) throws ArrayException;
    int findNegativeAmount(CustomArray array) throws ArrayException;
}

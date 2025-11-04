package main.com.gavruseva.task1.service;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import main.com.gavruseva.task1.exception.IncorrectConditionException;

public interface ArrayChange {
    void changeElements(CustomArray array, String condition, int whatChange, int changeTo) throws IncorrectConditionException, ArrayException;
}

package com.gavruseva.task1.service;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.exception.IncorrectConditionException;

public interface ArrayChange {
    void changeElements(CustomArray array, String condition, int whatChange, int changeTo) throws IncorrectConditionException, ArrayException;
}

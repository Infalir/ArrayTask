package main.com.gavruseva.task1.validator.impl;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.validator.ArrayValidator;

public class ArrayValidatorImpl implements ArrayValidator {
    public boolean isArrayValid(CustomArray array) {
        return array != null && array.getArray().length > 0 && array.getId() >= 0;
    }
}

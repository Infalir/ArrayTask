package com.gavruseva.task1.validator.impl;

import com.gavruseva.task1.entity.CustomArray;

public class ArrayValidatorImpl implements com.gavruseva.task1.validator.ArrayValidator {
    public boolean isArrayValid(CustomArray array) {
        return array != null && array.getArray().length > 0;
    }
}

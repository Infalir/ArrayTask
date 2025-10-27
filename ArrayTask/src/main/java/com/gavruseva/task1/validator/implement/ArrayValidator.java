package com.gavruseva.task1.validator.implement;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.validator.interfaces.ArrayValidatorInterface;

public class ArrayValidator implements ArrayValidatorInterface {
    public boolean isArrayValid(CustomArray array) {
        return array != null && array.getArray().length > 0;
    }
}

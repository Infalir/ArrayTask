package com.gavruseva.task1.validators.implement;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.validators.ArrayValidatorInterface;

public class ArrayValidator implements ArrayValidatorInterface {
    public boolean isValid(CustomArray array) {
        return array != null && array.getArray().length > 0;
    }
}

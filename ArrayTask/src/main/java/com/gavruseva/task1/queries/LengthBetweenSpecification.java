package com.gavruseva.task1.queries;

import com.gavruseva.task1.entity.CustomArray;

public class LengthBetweenSpecification implements Specification{
    private int minLength;
    private int maxLength;
    public LengthBetweenSpecification(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }
    @Override
    public boolean specify(CustomArray array) {
        return array.getArray().length >= minLength && array.getArray().length <= maxLength;
    }
}

package com.gavruseva.task1.builder;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;

public interface ArrayBuilder {
    ArrayBuilder setIntegerArray(int... array) throws ArrayException;
    ArrayBuilder setIndex(int id) throws ArrayException;
    CustomArray build() throws ArrayException;
}

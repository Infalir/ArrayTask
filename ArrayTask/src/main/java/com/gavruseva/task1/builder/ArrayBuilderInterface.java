package com.gavruseva.task1.builder;

import com.gavruseva.task1.entity.CustomArray;

public interface ArrayBuilderInterface {
    ArrayBuilderInterface setIntegerArray();
    CustomArray build();
}

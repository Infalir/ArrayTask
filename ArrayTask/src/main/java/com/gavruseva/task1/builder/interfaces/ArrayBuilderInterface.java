package com.gavruseva.task1.builder.interfaces;

import com.gavruseva.task1.entity.CustomArray;

public interface ArrayBuilderInterface {
    ArrayBuilderInterface setIntegerArray(int... array);
    CustomArray build();
}

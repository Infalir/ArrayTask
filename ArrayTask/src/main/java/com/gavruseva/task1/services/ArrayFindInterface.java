package com.gavruseva.task1.services;

import com.gavruseva.task1.entity.CustomArray;

public interface ArrayFindInterface {
    int findMin(CustomArray array);
    int findMax(CustomArray array);
    int findSum(CustomArray array);
    double findAvg(CustomArray array);
    int findPositiveAmount(CustomArray array);
    int findNegativeAmount(CustomArray array);
}

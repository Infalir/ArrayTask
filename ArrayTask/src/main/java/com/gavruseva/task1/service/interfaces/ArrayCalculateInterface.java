package com.gavruseva.task1.service.interfaces;

import com.gavruseva.task1.entity.CustomArray;

public interface ArrayCalculateInterface {
    int findMin(CustomArray array);
    int findMax(CustomArray array);
    int findSum(CustomArray array);
    double findAvg(CustomArray array);
    int findPositiveAmount(CustomArray array);
    int findNegativeAmount(CustomArray array);
}

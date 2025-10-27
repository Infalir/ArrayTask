package com.gavruseva.task1.service.interfaces;

import com.gavruseva.task1.entity.CustomArray;

public interface ArrayChangeInterface {
    void changeElements(CustomArray array, String condition, int whatChange, int changeTo);
}

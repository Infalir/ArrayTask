package com.gavruseva.task1.observer;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;

public interface ArrayObserver {
    void update(CustomArray array);
}

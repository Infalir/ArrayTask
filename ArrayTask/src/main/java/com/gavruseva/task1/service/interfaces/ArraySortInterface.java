package com.gavruseva.task1.service.interfaces;

import com.gavruseva.task1.entity.CustomArray;

public interface ArraySortInterface {
    void bubbleSort(CustomArray array);
    void selectionSort(CustomArray array);
    void insertionSort(CustomArray array);
}

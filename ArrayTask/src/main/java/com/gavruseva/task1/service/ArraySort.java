package com.gavruseva.task1.service;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;

public interface ArraySort {
    void bubbleSort(CustomArray array) throws ArrayException;
    void selectionSort(CustomArray array) throws ArrayException;
    void insertionSort(CustomArray array) throws ArrayException;
}

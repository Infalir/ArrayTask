package com.gavruseva.task1.repository;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {
    void addArray(CustomArray array) throws ArrayException;
    void removeArray(int id) throws ArrayException;
    List<CustomArray> sortArray(Comparator<CustomArray> comparator);
    List<CustomArray> getAllArrays() throws ArrayException;
    CustomArray getArrayById(int id);
}

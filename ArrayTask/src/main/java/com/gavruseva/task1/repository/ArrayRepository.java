package com.gavruseva.task1.repository;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.queries.Specification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {
    void addArray(CustomArray array) throws ArrayException;
    boolean removeArray(int id) throws ArrayException;
    List<CustomArray> sortArray(Comparator<CustomArray> comparator);
    List<CustomArray> getAllArrays() throws ArrayException;
    List<CustomArray> query(Specification spec);
}

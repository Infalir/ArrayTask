package com.gavruseva.task1.sorter;

import com.gavruseva.task1.entity.CustomArray;

import java.util.Comparator;

public class LengthComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray a1, CustomArray a2) {
        return Integer.compare(a1.getArray().length, a2.getArray().length);
    }
}

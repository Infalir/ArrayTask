package com.gavruseva.task1.sorter;

import com.gavruseva.task1.entity.CustomArray;

import java.util.Comparator;

public enum ArrayComparator implements Comparator<CustomArray> {
    ID{
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            return o1.getId() - o2.getId();
        }
    },

    LENGTH{
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            return o1.getArray().length - o2.getArray().length;
        }
    },

    FIRST_ELEMENT{
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            return o1.getArray()[0] - o2.getArray()[0];
        }
    }

}

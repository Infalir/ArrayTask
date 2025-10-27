package com.gavruseva.task1.entity;


import com.gavruseva.task1.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomArray {
    private final static Logger logger = LogManager.getLogger();
    private int[] array;

    public CustomArray(int... array) throws ArrayException {
        if (array == null || array.length == 0){
            logger.warn("Trying to create a null or empty array");
            throw new ArrayException("Can't create an array out of empty array");
        }
        this.array = array;
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int... array) throws ArrayException {
        if (array == null || array.length == 0){
            logger.warn("Trying to set a null or empty array");
            throw new ArrayException("Can't set an array from an empty array");
        }
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArray customArray = (CustomArray) o;
        if (customArray.getArray().length != array.length){
            return false;
        }
        for (int i = 0; i < customArray.getArray().length; i++) {
            if (array[i] != customArray.getArray()[i]){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 7;
        for (int i = 0; i < array.length; i++) {
            hashCode = 31 * hashCode + array[i] * 2 ^ i;
        }
        return hashCode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CustomArray [");
        for (int element : array){
            builder.append(element).append(" ");
        }
        return builder.append("]").toString();
    }
}

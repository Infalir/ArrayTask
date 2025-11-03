package com.gavruseva.task1.entity;


import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.observer.ArrayObservable;
import com.gavruseva.task1.observer.ArrayObserver;
import com.gavruseva.task1.observer.impl.ArrayObserverImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomArray implements ArrayObservable {
    private final static Logger logger = LogManager.getLogger();
    private int id;
    private int[] array;
    private ArrayObserver observer;

    public CustomArray(int[] array, int id) throws ArrayException {
        if (array == null || array.length == 0){
            logger.error("Trying to create a null or empty array");
            throw new ArrayException("Trying to create a null or empty array");
        }
        this.id = id;
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public void attach(ArrayObserver observer) {
        logger.info("An observer has been attached to an array");
        this.observer = observer;
    }

    @Override
    public void detach(ArrayObserver observer) {
        logger.info("An observer has been detached to an array");
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null){
            logger.info("Observers have been notified");
            observer.update(this);
        }
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int[] array) throws ArrayException {
        if (array == null ||array.length == 0){
            logger.warn("Trying to set a null or empty array");
            throw new ArrayException("Trying to set a null or empty array");
        }
        this.array = Arrays.copyOf(array, array.length);
        notifyObservers();
    }

    public int getId() {
        return id;
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

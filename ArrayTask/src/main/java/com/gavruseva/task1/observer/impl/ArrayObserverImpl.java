package com.gavruseva.task1.observer.impl;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.observer.ArrayObserver;
import com.gavruseva.task1.validator.ArrayValidator;
import com.gavruseva.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArrayObserverImpl {
    private final static Logger logger = LogManager.getLogger();
    List<ArrayObserver> observers;
    private static ArrayObserverImpl instance;
    private ArrayValidatorImpl validator;
    private ArrayObserverImpl() {
        validator = new ArrayValidatorImpl();
        observers = new ArrayList<ArrayObserver>();
    }
    public static ArrayObserverImpl getInstance() {
        if (instance == null) {
            instance = new ArrayObserverImpl();
        }
        return instance;
    }
    public void addObserver(ArrayObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(ArrayObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers(CustomArray array) throws ArrayException {
        if(!validator.isArrayValid(array)) {
            logger.error("Array is not valid");
            throw new ArrayException("Array is not valid");
        }
        for (ArrayObserver observer : observers) {
            observer.update(array);
        }
    }
}

package com.gavruseva.task1.warehouse.impl;

import com.gavruseva.task1.data.CalculatedData;
import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.observer.ArrayObserver;
import com.gavruseva.task1.validator.ArrayValidator;
import com.gavruseva.task1.validator.impl.ArrayValidatorImpl;
import com.gavruseva.task1.warehouse.StorageWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StorageWarehouseImpl implements StorageWarehouse, ArrayObserver {
    private final static Logger logger = LogManager.getLogger();
    private Map<Integer, CalculatedData> arraysData;
    private ArrayValidatorImpl arrayValidator;
    private static StorageWarehouseImpl instance;
    private StorageWarehouseImpl() {
        arrayValidator = new ArrayValidatorImpl();
        arraysData = new HashMap<>();
    }
    public static StorageWarehouseImpl getInstance() {
        if (instance == null) {
            instance = new StorageWarehouseImpl();
        }
        return instance;
    }
    @Override
    public void updateData(CustomArray array) {
        int id = array.getId();
        int[] temp = array.getArray();
        int sum = Arrays.stream(temp).sum();
        double avg = Arrays.stream(temp).average().orElseThrow();
        int min = Arrays.stream(temp).min().orElseThrow();
        int max = Arrays.stream(temp).max().orElseThrow();
        arraysData.put(id, new CalculatedData(sum, avg, min, max));
    }
    @Override
    public CalculatedData getData(int id) {
        return arraysData.get(id);
    }
    @Override
    public void update(CustomArray array) throws ArrayException {
        if(!arrayValidator.isArrayValid(array)) {
            logger.error("Array is not valid");
            throw new ArrayException("Array is not valid");
        }
        updateData(array);
    }
}

package com.gavruseva.task1.observer.impl;

import com.gavruseva.task1.data.ArrayData;
import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.observer.ArrayObserver;
import com.gavruseva.task1.warehouse.impl.StorageWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayObserverImpl implements ArrayObserver {
    private final static Logger logger = LogManager.getLogger();
    @Override
    public void update(CustomArray array) {
        logger.info("Updating data in the warehouse");
        int[] temp = array.getArray();
        int sum = Arrays.stream(temp).sum();
        double avg = Arrays.stream(temp).average().orElseThrow();
        int min = Arrays.stream(temp).min().orElseThrow();
        int max = Arrays.stream(temp).max().orElseThrow();
        StorageWarehouseImpl.getInstance().getMap().put(array.getId(), new ArrayData(sum, avg, min, max));
    }
}

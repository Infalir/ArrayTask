package com.gavruseva.task1.warehouse.impl;

import com.gavruseva.task1.data.ArrayData;
import com.gavruseva.task1.warehouse.StorageWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class StorageWarehouseImpl implements StorageWarehouse{
    private final static Logger logger = LogManager.getLogger();
    private Map<Integer, ArrayData> arraysData;
    private static StorageWarehouseImpl instance;
    private StorageWarehouseImpl() {
        arraysData = new HashMap<>();
    }
    public static StorageWarehouseImpl getInstance() {
        if (instance == null) {
            instance = new StorageWarehouseImpl();
        }
        return instance;
    }
    @Override
    public ArrayData getData(int id) {
        logger.info("Called a method for retrieving data from the warehouse");
        return arraysData.get(id);
    }

    @Override
    public Map<Integer, ArrayData> getMap() {
        logger.info("Called a method for retrieving map from the warehouse");
        return arraysData;
    }
}

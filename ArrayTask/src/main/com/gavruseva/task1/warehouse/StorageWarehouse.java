package main.com.gavruseva.task1.warehouse;

import main.com.gavruseva.task1.data.ArrayData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class StorageWarehouse {
    private final static Logger logger = LogManager.getLogger();
    private Map<Integer, ArrayData> arraysData;
    private static StorageWarehouse instance;

    private StorageWarehouse() {
        arraysData = new HashMap<>();
    }

    public static StorageWarehouse getInstance() {
        if (instance == null) {
            instance = new StorageWarehouse();
        }
        return instance;
    }

    public ArrayData getData(int id) {
        logger.info("Called a method for retrieving data from the warehouse");
        return arraysData.get(id);
    }

    public Map<Integer, ArrayData> getMap() {
        logger.info("Called a method for retrieving map from the warehouse");
        return arraysData;
    }
}

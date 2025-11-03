package com.gavruseva.task1.repository.impl;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.repository.ArrayRepository;
import com.gavruseva.task1.queries.Specification;
import com.gavruseva.task1.validator.impl.ArrayValidatorImpl;
import com.gavruseva.task1.warehouse.impl.StorageWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepositoryImpl implements ArrayRepository {
    private static ArrayRepositoryImpl instance;
    private final static Logger logger = LogManager.getLogger();
    private List<CustomArray> arrays;
    private final ArrayValidatorImpl validator;
    private ArrayRepositoryImpl() {
        arrays = new ArrayList<CustomArray>();
        validator = new ArrayValidatorImpl();
    }
    public static ArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ArrayRepositoryImpl();
        }
        logger.info("Create an Array Repository");
        return instance;
    }
    @Override
    public void addArray(CustomArray array) throws ArrayException {
        logger.info("Called a method for adding an array");
        if(!validator.isArrayValid(array)) {
            logger.error("Array is not valid");
            throw new ArrayException("Array is not valid");
        }
        array.notifyObservers();
        arrays.add(array);
    }
    @Override
    public boolean removeArray(int id) throws ArrayException {
        logger.info("Called a method for removing an array");
        CustomArray array = arrays.get(id);
        if(!validator.isArrayValid(array)) {
            logger.error("No such array");
            throw new ArrayException("Array is not valid");
        }
        StorageWarehouseImpl.getInstance().getMap().remove(array.getId());
        arrays.remove(array);
        return true;
    }
    @Override
    public List<CustomArray> query(Specification specification){
        logger.info("Called a method for querying an array");
        List<CustomArray> list = arrays.stream().filter(specification::specify).toList();
        return list;
    }
    @Override
    public List<CustomArray> getAllArrays() throws ArrayException {
        logger.info("Called a method for getting all arrays");
        return new ArrayList<>(arrays);
    }

    public List<CustomArray> sortArray(Comparator<CustomArray> comparator) {
        logger.info("Called a method for sorting arrays");
        List<CustomArray> sorted = new ArrayList<>(arrays);
        sorted.sort(comparator);
        for(CustomArray array : sorted) {
            logger.info(array.toString());
        }
        return sorted;
    }

}

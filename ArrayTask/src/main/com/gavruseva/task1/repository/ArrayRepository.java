package main.com.gavruseva.task1.repository;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import main.com.gavruseva.task1.queries.Specification;
import main.com.gavruseva.task1.validator.impl.ArrayValidatorImpl;
import main.com.gavruseva.task1.warehouse.StorageWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepository {
    private static ArrayRepository instance;
    private final static Logger logger = LogManager.getLogger();
    private List<CustomArray> arrays;
    private final ArrayValidatorImpl validator;

    private ArrayRepository() {
        arrays = new ArrayList<CustomArray>();
        validator = new ArrayValidatorImpl();
    }
    public static ArrayRepository getInstance() {
        if (instance == null) {
            instance = new ArrayRepository();
        }
        logger.info("Create an Array Repository");
        return instance;
    }

    public void addArray(CustomArray array) throws ArrayException {
        logger.info("Called a method for adding an array");
        if(!validator.isArrayValid(array)) {
            logger.error("Array is not valid");
            throw new ArrayException("Can't create an invalid array");
        }
        array.notifyObservers();
        arrays.add(array);
    }

    public boolean removeArray(int id) throws ArrayException {
        logger.info("Called a method for removing an array");
        CustomArray array = arrays.get(id);
        if(!validator.isArrayValid(array)) {
            logger.error("No such array");
            throw new ArrayException("Can't remove nonexistent array");
        }
        StorageWarehouse.getInstance().getMap().remove(array.getId());
        arrays.remove(array);
        return true;
    }

    public List<CustomArray> query(Specification specification){
        logger.info("Called a method for querying an array");
        List<CustomArray> list = arrays.stream().filter(specification::specify).toList();
        return list;
    }

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

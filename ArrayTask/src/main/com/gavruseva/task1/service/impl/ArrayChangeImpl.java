package main.com.gavruseva.task1.service.impl;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import main.com.gavruseva.task1.exception.IncorrectConditionException;
import main.com.gavruseva.task1.service.ArrayChange;
import main.com.gavruseva.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayChangeImpl implements ArrayChange {
    private final static Logger logger = LogManager.getLogger();

    @Override
    public void changeElements(CustomArray array, String condition, int whatChange, int changeTo) throws IncorrectConditionException, ArrayException {
        ArrayValidatorImpl validator = new ArrayValidatorImpl();
        logger.info("Method for changing elements in an array by condition is called");
        if(!validator.isArrayValid(array)){
            logger.warn("Array is not valid for changing elements");
            throw new ArrayException("Array is not valid");
        }
        int[] tempArray = array.getArray();
        switch (condition.trim()) {
            case ("<"):
                for (int i = 0; i < tempArray.length; i++) {
                    if (tempArray[i] < whatChange) {
                        tempArray[i] = changeTo;
                    }
                }
                array.setArray(tempArray);
                break;
            case (">"):
                for (int i = 0; i < tempArray.length; i++) {
                    if (tempArray[i] > whatChange) {
                        tempArray[i] = changeTo;
                    }
                }
                array.setArray(tempArray);
                break;
            case ("="):
                for (int i = 0; i < tempArray.length; i++) {
                    if (tempArray[i] == whatChange) {
                        tempArray[i] = changeTo;
                    }
                }
                array.setArray(tempArray);
                break;
            case (">="):
                for (int i = 0; i < tempArray.length; i++) {
                    if (tempArray[i] >= whatChange) {
                        tempArray[i] = changeTo;
                    }
                }
                array.setArray(tempArray);
                break;
            case ("<="):
                for (int i = 0; i < tempArray.length; i++) {
                    if (tempArray[i] <= whatChange) {
                        tempArray[i] = changeTo;
                    }
                }
                array.setArray(tempArray);
                break;
            case ("!="):
                for (int i = 0; i < tempArray.length; i++) {
                    if (tempArray[i] != whatChange) {
                        tempArray[i] = changeTo;
                    }
                }
                array.setArray(tempArray);
                break;
            default:
                logger.error("Incorrect condition");
                throw new IncorrectConditionException();
        }
    }
}

package com.gavruseva.task1.service.implement;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.IncorrectConditionException;
import com.gavruseva.task1.service.interfaces.ArrayChangeInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayChange implements ArrayChangeInterface {
    private final static Logger logger = LogManager.getLogger();

    @Override
    public void changeElements(CustomArray array, String condition, int whatChange, int changeTo){
        logger.info("Method for changing elements in an array by condition is called");
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

package main.com.gavruseva.task1.service.impl;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import main.com.gavruseva.task1.exception.IncorrectConditionException;
import main.com.gavruseva.task1.service.ArrayChange;
import main.com.gavruseva.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayStreamChangeImpl implements ArrayChange {
    private final static Logger logger = LogManager.getLogger();
    private final ArrayValidatorImpl arrayValidatorImpl = new ArrayValidatorImpl();
    private String[] arrayOfCondition = new String[]{">", "<", "=", "!=", "<=", ">="};

    @Override
    public void changeElements(CustomArray customArray, String condition, int whatChange, int ch) throws ArrayException, IncorrectConditionException {
        logger.info("Method for change number with condition for stream is called");
        if (!arrayValidatorImpl.isArrayValid(customArray)) {
            logger.error("Array is not valid for changing elements using stream");
            throw new ArrayException("Array is null or empty");
        }
        String trimmedCondition = condition.trim();
        boolean notCorrectCondition = Arrays.stream(arrayOfCondition).noneMatch(x -> x.equals(trimmedCondition));
        if (notCorrectCondition) {
            logger.error("Condition for changing elements using stream is not correct");
            throw new IncorrectConditionException();
        }
        int[] tempArray = customArray.getArray();
        int[] newArray = Arrays.stream(tempArray)
                .map(x -> {
                    switch (trimmedCondition) {
                        case ("<"):
                            if (x < whatChange) {
                                x = ch;
                            }
                            break;
                        case (">"):
                            if (x > whatChange) {
                                x = ch;
                            }
                            break;
                        case ("="):
                            if (x == whatChange) {
                                x = ch;
                            }
                            break;
                        case (">="):
                            if (x >= whatChange) {
                                x = ch;
                            }
                            break;
                        case ("<="):
                            if (x <= whatChange) {
                                x = ch;
                            }
                            break;
                        case ("!="):
                            if (x != whatChange) {
                                x = ch;
                            }
                            break;
                    }
                    return x;
                }).toArray();
        customArray.setArray(newArray);
    }
}

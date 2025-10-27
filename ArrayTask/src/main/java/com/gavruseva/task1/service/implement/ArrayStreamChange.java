package com.gavruseva.task1.service.implement;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.exception.IncorrectConditionException;
import com.gavruseva.task1.service.interfaces.ArrayChangeInterface;
import com.gavruseva.task1.validator.implement.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayStreamChange implements ArrayChangeInterface {
    private final static Logger logger = LogManager.getLogger();
    private final ArrayValidator arrayValidator = new ArrayValidator();
    private String[] arrayOfCondition = new String[]{">", "<", "=", "!=", "<=", ">="};

    @Override
    public void changeElements(CustomArray customArray, String condition, int whatChange, int ch) throws ArrayException, IncorrectConditionException {
        logger.info("Method for change number  with condition for stream is called");
        if (!arrayValidator.isArrayValid(customArray)) {
            throw new ArrayException("Array is null");
        }
        String trimmedCondition = condition.trim();
        boolean notCorrectCondition = Arrays.stream(arrayOfCondition)
                .noneMatch(x -> x.equals(trimmedCondition));
        if (notCorrectCondition) {
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

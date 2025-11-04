package main.com.gavruseva.task1.validator.impl;

import main.com.gavruseva.task1.validator.StringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringValidatorImpl implements StringValidator {
    private final static Logger logger = LogManager.getLogger();
    private final String LINE_REGEX = "(-?\\d+([,]?\\s+)?)*";
    private final String SPLIT_REGEX = ",\\s+";
    private final String NUMBER_REGEX = "-?\\d+";

    @Override
    public boolean isStringValid(String str) {
        logger.info("Method validate of string called");
        if (str.isEmpty()) {
            logger.warn("String is empty");
            return false;
        }
        boolean isVal = false;
        if(str.matches(LINE_REGEX)){
            String[] elements = str.split(SPLIT_REGEX);
            isVal=true;
            for (String element : elements) {
                if (!element.matches(NUMBER_REGEX)) {
                    logger.warn("String contains invalid characters");
                    isVal = false;
                    break;
                }
            }
        }
        return isVal;
    }
}

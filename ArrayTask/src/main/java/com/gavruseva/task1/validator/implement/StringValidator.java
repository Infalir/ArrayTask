package com.gavruseva.task1.validator.implement;

import com.gavruseva.task1.validator.interfaces.StringValidatorInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringValidator implements StringValidatorInterface {
    private final static Logger logger = LogManager.getLogger();

    @Override
    public boolean isStringValid(String str) {
        logger.info("Method validate of string called");
        if (str.isEmpty()) {
            logger.warn("String is empty");
            return false;
        }
        boolean isVal = false;
        if(str.matches("(-?\\d+[,]?\\s+?)*")){
            String[] elements = str.split(",\\s+");
            isVal=true;
            for (String element : elements) {
                if (!element.matches("-?\\d+")) {
                    logger.warn("String contains invalid characters");
                    isVal = false;
                    break;
                }
            }
        }
        return isVal;
    }
}

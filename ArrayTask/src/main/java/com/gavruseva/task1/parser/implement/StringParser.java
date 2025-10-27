package com.gavruseva.task1.parser.implement;

import com.gavruseva.task1.parser.interfaces.StringParserInterface;
import com.gavruseva.task1.validator.implement.StringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class StringParser implements StringParserInterface {
    private final static Logger logger = LogManager.getLogger();

    @Override
    public int[] parseString(List<String> arrayList) {
        logger.info("Method for parsing String is called");
        int[] arrayInt = null;
        StringValidator stringValidate = new StringValidator();
        for (String s : arrayList) {
            if (stringValidate.isStringValid(s)) {
                String[] elements = s.split(",\\s+");
                arrayInt = new int[elements.length];
                for (int i = 0; i < elements.length; i++) {
                    arrayInt[i] = Integer.parseInt(elements[i]);
                }
              break;
            }

        }
        return arrayInt;
    }
}

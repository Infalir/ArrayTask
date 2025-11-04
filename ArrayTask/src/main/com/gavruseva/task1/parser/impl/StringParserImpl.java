package main.com.gavruseva.task1.parser.impl;

import main.com.gavruseva.task1.parser.StringParser;
import main.com.gavruseva.task1.validator.impl.StringValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class StringParserImpl implements StringParser {
    private final static Logger logger = LogManager.getLogger();
    private final String SPLIT_REGEX = ",\\s+";
    @Override
    public int[] parseString(List<String> arrayList) {
        logger.info("Method for parsing String is called");
        int[] arrayInt = null;
        StringValidatorImpl stringValidate = new StringValidatorImpl();
        for (String s : arrayList) {
            if (stringValidate.isStringValid(s)) {
                String[] elements = s.split(SPLIT_REGEX);
                arrayInt = new int[elements.length];
                for (int i = 0; i < elements.length; i++) {
                    arrayInt[i] = Integer.parseInt(elements[i]);
                }
            }

        }
        return arrayInt;
    }
}

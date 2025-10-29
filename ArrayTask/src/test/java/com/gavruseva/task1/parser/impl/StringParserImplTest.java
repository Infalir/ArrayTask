package com.gavruseva.task1.parser.impl;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringParserImplTest {
    private StringParserImpl stringParserImpl;

    @Test
    void testParsingStrings() throws ArrayException {
        stringParserImpl = new StringParserImpl();
        int[] expectedArray = {1, 2, 3, 4, 5};
        List<String> listToParse = Arrays.asList("1, 2, 3, 4, 5", "1v, 7h, 0, 0, 0");
        CustomArray actualArray = new CustomArray (stringParserImpl.parseString(listToParse), 0);
        assertArrayEquals(expectedArray, actualArray.getArray());
    }
}
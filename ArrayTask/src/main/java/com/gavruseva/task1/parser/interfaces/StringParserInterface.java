package com.gavruseva.task1.parser.interfaces;

import com.gavruseva.task1.exception.ArrayException;

import java.util.List;

public interface StringParserInterface {
    int[] parseString(List<String> s) throws ArrayException;
}

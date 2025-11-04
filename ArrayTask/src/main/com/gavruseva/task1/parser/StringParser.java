package main.com.gavruseva.task1.parser;

import main.com.gavruseva.task1.exception.ArrayException;

import java.util.List;

public interface StringParser {
    int[] parseString(List<String> s) throws ArrayException;
}

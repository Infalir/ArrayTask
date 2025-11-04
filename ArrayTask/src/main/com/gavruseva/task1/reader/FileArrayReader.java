package main.com.gavruseva.task1.reader;

import main.com.gavruseva.task1.exception.FileException;

import java.util.List;

public interface FileArrayReader {
    List<String> readLinesFromFile(String path) throws FileException;
}

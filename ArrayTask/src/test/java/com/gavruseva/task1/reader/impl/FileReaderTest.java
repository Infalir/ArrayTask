package com.gavruseva.task1.reader.impl;

import com.gavruseva.task1.exception.FileException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {
    private FileArrayReaderImpl fileReader;
    @BeforeEach
    public void setUp() {
        fileReader = new FileArrayReaderImpl();
    }
    @Test
    public void testReadingLinesFromFile() throws FileException {
        List<String> lines = fileReader.readLinesFromFile("src/test/resources/array.txt");
        List<String> expectedList = Arrays.asList("6, -1, -4, 11, -9,0, 45,-55","999,a 2, 0g, -78, 35, 43gda, -2, 98, 77, -145, 3, 0, null",
                "2, 46, 8, 3, 1, 0");
        assertEquals(expectedList, lines);
    }

    @Test
    public void testThrowsForInvalidFileName(){
        assertThrows(FileException.class, () -> fileReader.readLinesFromFile(""));
    }
}
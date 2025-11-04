package main.com.gavruseva.task1.validator.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileNameValidatorImplTest {
    private FileNameValidatorImpl fileNameValidatorImpl;
    @BeforeEach
    public void setUp() {
     fileNameValidatorImpl = new FileNameValidatorImpl();
    }
    @Test
    public void testValidFileName() {
        assertTrue(fileNameValidatorImpl.isFileNameValid("test/resources/array.txt"));
    }
    @Test
    public void testNonExistentFile() {
        assertFalse(fileNameValidatorImpl.isFileNameValid("test/resources/invalid.txt"));
    }

    @Test
    public void testNullFileName(){
        assertFalse(fileNameValidatorImpl.isFileNameValid(null));
    }

    @Test
    public void testEmptyFileName(){
        assertFalse(fileNameValidatorImpl.isFileNameValid(""));
    }
}
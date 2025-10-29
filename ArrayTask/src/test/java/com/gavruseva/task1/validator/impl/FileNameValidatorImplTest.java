package com.gavruseva.task1.validator.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileNameValidatorImplTest {
    private FileNameValidatorImpl fileNameValidatorImpl;
    @BeforeEach
    void setUp() {
     fileNameValidatorImpl = new FileNameValidatorImpl();
    }
    @Test
    void testValidFileName() {
        assertTrue(fileNameValidatorImpl.isFileNameValid("src/test/resources/array.txt"));
    }
    @Test
    void testNonExistentFile() {
        assertFalse(fileNameValidatorImpl.isFileNameValid("src/test/resources/invalid.txt"));
    }

    @Test
    void testNullFileName(){
        assertFalse(fileNameValidatorImpl.isFileNameValid(null));
    }

    @Test
    void testEmptyFileName(){
        assertFalse(fileNameValidatorImpl.isFileNameValid(""));
    }
}
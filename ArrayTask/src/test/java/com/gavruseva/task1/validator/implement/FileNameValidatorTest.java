package com.gavruseva.task1.validator.implement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileNameValidatorTest {
    private FileNameValidator fileNameValidator;
    @BeforeEach
    void setUp() {
     fileNameValidator = new FileNameValidator();
    }
    @Test
    void testValidFileName() {
        assertTrue(fileNameValidator.isFileNameValid("src/test/resources/array.txt"));
    }
    @Test
    void testNonExistentFile() {
        assertFalse(fileNameValidator.isFileNameValid("src/test/resources/invalid.txt"));
    }

    @Test
    void testNullFileName(){
        assertFalse(fileNameValidator.isFileNameValid(null));
    }

    @Test
    void testEmptyFileName(){
        assertFalse(fileNameValidator.isFileNameValid(""));
    }
}
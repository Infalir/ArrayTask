package com.gavruseva.task1.validator.implement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringValidatorTest {
    private StringValidator validator;
    @BeforeEach
    void setUp() {
        validator = new StringValidator();
    }
    @Test
    void testValidString(){
        assertTrue(validator.isStringValid("1, 2, 3, 4, 5"));
    }
    @Test
    void testEmptyString(){
        assertFalse(validator.isStringValid(""));
    }
    @Test
    void testInvalidString(){
        assertFalse(validator.isStringValid("axcvbn"));
    }
}
package com.gavruseva.task1.validator.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringValidatorImplTest {
    private StringValidatorImpl validator;
    @BeforeEach
    void setUp() {
        validator = new StringValidatorImpl();
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
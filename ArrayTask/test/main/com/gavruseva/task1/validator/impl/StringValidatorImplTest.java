package main.com.gavruseva.task1.validator.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringValidatorImplTest {
    private StringValidatorImpl validator;
    @BeforeEach
    public void setUp() {
        validator = new StringValidatorImpl();
    }
    @Test
    public void testValidString(){
        assertTrue(validator.isStringValid("1, 2, 3, 4, 5"));
    }
    @Test
    public void testEmptyString(){
        assertFalse(validator.isStringValid(""));
    }
    @Test
    public void testInvalidString(){
        assertFalse(validator.isStringValid("axcvbn"));
    }
}
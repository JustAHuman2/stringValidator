package ru.x5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {
    
    private Validator validator;

    @Before
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void givenValidString_whenValidate_thenTrue_case1() {
        assertTrue(validator.validate("abc def"));
    }

    @Test
    public void givenValidString_whenValidate_thenTrue_case2() {
        assertTrue(validator.validate("aaabbb"));
    }

    @Test
    public void givenValidString_whenValidate_thenTrue_case3() {
        assertTrue(validator.validate("aabbccc"));
    }

    @Test
    public void givenValidString_whenValidate_thenTrue_case4() {
        assertTrue(validator.validate("ABCBCA abc bca"));
    }

    @Test
    public void givenInvalidString_whenValidate_thenFalse_case1() {
        assertFalse(validator.validate("aaaaabbcc"));
    }

    @Test
    public void givenInvalidString_whenValidate_thenFalse_case2() {
        assertFalse(validator.validate("aaabbbc"));
    }

    @Test
    public void givenInvalidString_whenValidate_thenFalse_case3() {
        assertFalse(validator.validate("AAaabbbb"));
    }

    @Test
    public void givenInvalidString_whenValidate_thenFalse_case4() {
        assertFalse(validator.validate("aaabbbcc"));
    }
}
package com.validator.PasswordValidator.service.rule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NullRuleTest {
    private NullRule rule;

    @BeforeEach
    public void setup() {
        rule = new NullRule();
    }

    @Test
    public void testApply() {
        assertTrue(rule.apply("ab1234567890"));
        assertFalse(rule.apply( null));
    }

    @Test
    public void testIsMandatory() {
        assertTrue(rule.isMandatory());
    }
}

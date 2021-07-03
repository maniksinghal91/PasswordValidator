package com.validator.PasswordValidator.service.rule;

import com.validator.PasswordValidator.config.PasswordValidatorConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LowerCaseLetterRuleTest {
    private LowerCaseLetterRule rule;

    @BeforeEach
    public void setup() {
        PasswordValidatorConfig passwordValidatorConfig = mock(PasswordValidatorConfig.class);
        when(passwordValidatorConfig.getMinLowerCase()).thenReturn(1);

        rule = new LowerCaseLetterRule(passwordValidatorConfig);
    }

    @Test
    public void testApply() {
        assertTrue(rule.apply("ab1234567890"));
        assertFalse(rule.apply("123490"));
        assertFalse(rule.apply( null));
    }

    @Test
    public void testIsMandatory() {
        assertTrue(rule.isMandatory());
    }
}

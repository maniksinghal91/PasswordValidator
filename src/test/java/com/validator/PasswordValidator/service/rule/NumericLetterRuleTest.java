package com.validator.PasswordValidator.service.rule;

import com.validator.PasswordValidator.config.PasswordValidatorConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumericLetterRuleTest {
    private NumericLetterRule rule;

    @BeforeEach
    public void setup() {
        PasswordValidatorConfig passwordValidatorConfig = mock(PasswordValidatorConfig.class);
        when(passwordValidatorConfig.getMinNumeric()).thenReturn(2);

        rule = new NumericLetterRule(passwordValidatorConfig);
    }

    @Test
    public void testApply() {
        assertTrue(rule.apply("890SF#%s"));
        assertFalse(rule.apply("asvbergernSDFDF"));
        assertFalse(rule.apply( null));
    }

    @Test
    public void testIsMandatory() {
        assertFalse(rule.isMandatory());
    }
}

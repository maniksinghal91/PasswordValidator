package com.validator.PasswordValidator.service;

import com.validator.PasswordValidator.config.PasswordValidatorConfig;
import com.validator.PasswordValidator.service.rule.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PasswordValidatorServiceTest {
    private PasswordValidatorConfig passwordValidatorConfig;

    private PasswordValidationService systemUnderTest;

    @BeforeEach
    public void setup() {
        passwordValidatorConfig = mock(PasswordValidatorConfig.class);
        when(passwordValidatorConfig.getRequired()).thenReturn(1);

        systemUnderTest = new PasswordValidationService(
                Arrays.asList(lengthRule(), signRule()), passwordValidatorConfig);
    }

    @Test
    public void testValidate() {
        assertTrue(systemUnderTest.validate("test!@"));
        assertFalse(systemUnderTest.validate("test"));
        assertFalse(systemUnderTest.validate("test1234567890"));
        assertTrue(systemUnderTest.validate("test1234567890!@"));
    }

    private Rule<String> lengthRule() {
        return new Rule<String>() {
            @Override
            public Boolean apply(String parameter) {
                return parameter.length() > 10;
            }

            @Override
            public Boolean isMandatory() {
                return false;
            }
        };
    }

    private Rule<String> signRule() {
        return new Rule<String>() {
            @Override
            public Boolean apply(String parameter) {
                return parameter.contains("!@");
            }

            @Override
            public Boolean isMandatory() {
                return true;
            }
        };
    }
}

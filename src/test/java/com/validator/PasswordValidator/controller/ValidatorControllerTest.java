package com.validator.PasswordValidator.controller;

import com.validator.PasswordValidator.model.PasswordValidationRequest;
import com.validator.PasswordValidator.model.PasswordValidationResponse;
import com.validator.PasswordValidator.service.PasswordValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ValidatorControllerTest {

    private PasswordValidationService passwordValidationService;

    private ValidatorController systemUnderTest;

    @BeforeEach
    public void setup() {
        passwordValidationService = mock(PasswordValidationService.class);

        systemUnderTest = new ValidatorController(passwordValidationService);
    }

    @Test
    public void testValidateAccepted() {
        when(passwordValidationService.validate(anyString())).thenReturn(true);

        PasswordValidationRequest request = new PasswordValidationRequest();
        request.setPassword("Dummy");

        PasswordValidationResponse response = systemUnderTest.validate(request);
        assertTrue(response.getAccepted());
    }

    @Test
    public void testValidateRejected() {
        when(passwordValidationService.validate(anyString())).thenReturn(false);

        PasswordValidationRequest request = new PasswordValidationRequest();
        request.setPassword("Dummy");

        PasswordValidationResponse response = systemUnderTest.validate(request);
        assertFalse(response.getAccepted());
    }
}

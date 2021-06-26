package com.validator.PasswordValidator.controller;

import com.validator.PasswordValidator.model.ValidationRequest;
import com.validator.PasswordValidator.model.ValidationResponse;
import com.validator.PasswordValidator.service.PasswordValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorController {

    private PasswordValidationService passwordValidationService;

    @Autowired
    public ValidatorController(PasswordValidationService passwordValidationService) {
        this.passwordValidationService = passwordValidationService;
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ValidationResponse validate(ValidationRequest request) {
        ValidationResponse response = new ValidationResponse();
        response.setAccepted(passwordValidationService.validate(request.getPassword()));
        return response;
    }
}

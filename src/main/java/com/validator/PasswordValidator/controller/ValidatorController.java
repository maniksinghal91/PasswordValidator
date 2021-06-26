package com.validator.PasswordValidator.controller;

import com.validator.PasswordValidator.model.ValidationRequest;
import com.validator.PasswordValidator.model.ValidationResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorController {

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ValidationResponse validate(ValidationRequest request) {
        return null;
    }
}

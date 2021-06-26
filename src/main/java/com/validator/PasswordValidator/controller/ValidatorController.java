package com.validator.PasswordValidator.controller;

import com.validator.PasswordValidator.model.PasswordValidationRequest;
import com.validator.PasswordValidator.model.PasswordValidationResponse;
import com.validator.PasswordValidator.service.PasswordValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidatorController {

    private PasswordValidationService passwordValidationService;

    @Autowired
    public ValidatorController(PasswordValidationService passwordValidationService) {
        this.passwordValidationService = passwordValidationService;
    }

    @ResponseBody
    @RequestMapping(value = "/validate", method = RequestMethod.POST, headers = { "Content-Type=application/json" })
    public PasswordValidationResponse validate(@RequestBody PasswordValidationRequest request) {
        PasswordValidationResponse response = new PasswordValidationResponse();
        response.setAccepted(passwordValidationService.validate(request.getPassword()));
        return response;
    }
}

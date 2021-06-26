package com.validator.PasswordValidator.service;

import com.validator.PasswordValidator.config.PasswordValidatorConfig;
import com.validator.PasswordValidator.service.rule.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordValidationService {

    private final List<Rule<String>> passwordRules;
    private final PasswordValidatorConfig passwordValidatorConfig;

    @Autowired
    public PasswordValidationService(List<Rule<String>> passwordRules, PasswordValidatorConfig passwordValidatorConfig) {
        this.passwordRules = passwordRules;
        this.passwordValidatorConfig = passwordValidatorConfig;
    }

    public boolean validate(String password) {
        int accepted = 0;
        for (Rule<String> rule : passwordRules) {
            if (rule.apply(password))
                accepted++;
            else if (rule.isMandatory())
                return false;
        }
       return accepted >= passwordValidatorConfig.getRequired();
    }
}

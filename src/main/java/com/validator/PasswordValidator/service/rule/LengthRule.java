package com.validator.PasswordValidator.service.rule;

import com.validator.PasswordValidator.config.PasswordValidatorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LengthRule implements Rule<String> {
    private PasswordValidatorConfig config;

    @Autowired
    public LengthRule(PasswordValidatorConfig config) {
        this.config = config;
    }

    @Override
    public Boolean apply(String parameter) {
        return parameter != null && parameter.length() >= config.getLength();
    }

    @Override
    public Boolean isMandatory() {
        return false;
    }
}

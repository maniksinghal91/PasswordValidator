package com.validator.PasswordValidator.service.rule;

import org.springframework.stereotype.Component;

@Component
public class NullRule implements Rule<String> {

    @Override
    public Boolean apply(String parameter) {
        return parameter != null;
    }

    @Override
    public Boolean isMandatory() {
        return true;
    }
}

package com.validator.PasswordValidator.service.rule;

import com.validator.PasswordValidator.config.PasswordValidatorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumericLetterRule implements Rule<String> {
    private PasswordValidatorConfig config;

    @Autowired
    public NumericLetterRule(PasswordValidatorConfig config) {
        this.config = config;
    }

    @Override
    public Boolean apply(String parameter) {
        if (parameter == null)
            return false;

        int count = 0;
        for (char c : parameter.toCharArray())
            if (c >= '0' && c <= '9')
                count++;
        return count > config.getMinNumeric();
    }

    @Override
    public Boolean isMandatory() {
        return false;
    }
}

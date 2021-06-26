package com.validator.PasswordValidator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordValidatorConfig {

    @Value("${validator.password.required}")
    private int required;

    @Value("${validator.password.length}")
    private int length;

    @Value("${validator.password.letters.lowercase}")
    private int minLowerCase;

    @Value("${validator.password.letters.uppercase}")
    private int minUpperCase;

    @Value("${validator.password.letters.numeric}")
    private int minNumeric;

    public int getRequired() {
        return required;
    }

    public int getLength() {
        return length;
    }

    public int getMinLowerCase() {
        return minLowerCase;
    }

    public int getMinUpperCase() {
        return minUpperCase;
    }

    public int getMinNumeric() {
        return minNumeric;
    }
}

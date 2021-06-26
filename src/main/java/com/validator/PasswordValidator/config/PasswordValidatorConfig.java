package com.validator.PasswordValidator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("validator.password")
public class PasswordValidatorConfig {
    @Value("required")
    private int required;

    @Value("length")
    private int length;

    @Value("letters.lowercase")
    private int minLowerCase;

    @Value("letters.uppercase")
    private int minUpperCase;

    @Value("letters.numeric")
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

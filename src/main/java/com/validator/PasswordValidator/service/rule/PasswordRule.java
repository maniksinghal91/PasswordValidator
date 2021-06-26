package com.validator.PasswordValidator.service.rule;

import com.validator.PasswordValidator.config.PasswordValidatorConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class PasswordRule implements InitializingBean {
    private PasswordValidatorConfig config;

    private List<Rule<String>> rules;

    @Autowired
    public PasswordRule(PasswordValidatorConfig config) {
        this.config = config;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Rule<String> nullRule = Objects::nonNull;
        Rule<String> lengthRule = (password) -> password.length() > config.getLength();
        Rule<String> upperCaseRule = (password) -> {
            int count = 0;
            for (char c : password.toCharArray())
                if (c >= 'A' && c <= 'Z')
                    count++;
            return count > config.getMinUpperCase();
        };
        Rule<String> lowerCaseRule = (password) -> {
            int count = 0;
            for (char c : password.toCharArray())
                if (c >= 'a' && c <= 'z')
                    count++;
            return count > config.getMinLowerCase();
        };
        Rule<String> numericRule = (password) -> {
            int count = 0;
            for (char c : password.toCharArray())
                if (c >= '0' && c <= '9')
                    count++;
            return count > config.getMinNumeric();
        };

        rules.add(nullRule);
        rules.add(lengthRule);
        rules.add(upperCaseRule);
        rules.add(lowerCaseRule);
        rules.add(numericRule);
    }

    public List<Rule<String>> getRules() {
        return rules;
    }

}

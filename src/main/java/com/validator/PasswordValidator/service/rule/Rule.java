package com.validator.PasswordValidator.service.rule;

public interface Rule<P> {
    Boolean apply(P parameter);
}

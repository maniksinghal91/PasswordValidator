package com.validator.PasswordValidator.model;

public class ValidationResponse {
    private boolean accepted;

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}

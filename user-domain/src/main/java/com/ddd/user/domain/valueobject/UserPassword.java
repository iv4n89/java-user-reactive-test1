package com.ddd.user.domain.valueobject;

import org.ddd.shared.domain.valueobject.StringValueObject;

public class UserPassword extends StringValueObject {
    public UserPassword(String value) {
        super(value);
    }

    @Override
    protected void isValid() {
        super.isValid();
        isValidPassword();
    }

    private void isValidPassword() {
        if (this.value.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }

        if (!this.value.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Password must contain at least one number");
        }

        if (!this.value.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter");
        }

        if (!this.value.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter");
        }

        if (!this.value.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            throw new IllegalArgumentException("Password must contain at least one special character");
        }
    }
}

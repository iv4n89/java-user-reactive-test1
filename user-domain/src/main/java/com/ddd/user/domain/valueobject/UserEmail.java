package com.ddd.user.domain.valueobject;

import org.ddd.shared.domain.valueobject.StringValueObject;

public class UserEmail extends StringValueObject {
    public UserEmail(String value) {
        super(value);
    }

    @Override
    protected void isValid() {
        super.isValid();
        isValidEmail();
    }

    private void isValidEmail() {
        if (!this.value.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (!this.value.contains(".")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
}
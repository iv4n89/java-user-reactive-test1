package com.ddd.user.domain.valueobject;

import org.ddd.shared.domain.valueobject.StringValueObject;

public class UserUsername extends StringValueObject {
    public UserUsername(String value) {
        super(value);
    }

    @Override
    protected void isValid() {
        super.isValid();
        isValidUsername();
    }

    private void isValidUsername() {
        if (this.value.length() < 8) {
            throw new IllegalArgumentException("Username must be at least 8 characters");
        }
    }
}

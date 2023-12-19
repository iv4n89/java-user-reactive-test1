package com.ddd.user.domain.adapters.input.service;

import com.ddd.user.domain.ports.input.service.UserDomainService;
import com.ddd.user.domain.valueobject.UserPassword;

public final class UserDomainServiceImpl implements UserDomainService {

    @Override
    public String hashPassword(UserPassword password) {
        String passValue = password.value();
        return passValue; //TODO: hash password
    }
}

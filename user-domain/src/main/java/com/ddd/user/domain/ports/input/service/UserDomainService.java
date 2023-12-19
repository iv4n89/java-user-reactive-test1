package com.ddd.user.domain.ports.input.service;

import com.ddd.user.domain.valueobject.UserPassword;

public interface UserDomainService {
    String hashPassword(UserPassword password);
}

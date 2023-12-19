package com.ddd.user.domain.ports.input.service;

import com.ddd.user.domain.model.UserModel;

public interface UserApplicationService {
    UserModel registerUser(String username, String name, String email, String password);
    UserModel findUser(String username);
    UserModel findUserByEmail(String email);
}

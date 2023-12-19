package com.ddd.user.domain.ports.input.usecases;

import com.ddd.user.domain.model.UserModel;
import com.ddd.user.domain.valueobject.UserEmail;
import com.ddd.user.domain.valueobject.UserUsername;

import java.util.Optional;

public interface UserFinder {
    Optional<UserModel> findUser(UserUsername username);
    Optional<UserModel> findUser(UserEmail email);
}

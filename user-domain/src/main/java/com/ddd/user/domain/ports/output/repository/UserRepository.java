package com.ddd.user.domain.ports.output.repository;

import com.ddd.user.domain.model.UserModel;
import com.ddd.user.domain.valueobject.UserEmail;
import com.ddd.user.domain.valueobject.UserUsername;

import java.util.Optional;

public interface UserRepository {
    UserModel save(UserModel user);
    Optional<UserModel> findByUsername(UserUsername username);
    Optional<UserModel> findByEmail(UserEmail email);
}

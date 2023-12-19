package com.ddd.user.domain.ports.input.usecases;

import com.ddd.user.domain.model.UserModel;
import com.ddd.user.domain.valueobject.UserEmail;
import com.ddd.user.domain.valueobject.UserName;
import com.ddd.user.domain.valueobject.UserPassword;
import com.ddd.user.domain.valueobject.UserUsername;

public interface UserRegistration {
    UserModel registerUser(UserUsername username, UserName name, UserEmail email, UserPassword password);
}

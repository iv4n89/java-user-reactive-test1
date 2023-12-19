package com.ddd.user.application.adapters.input.service;

import org.springframework.stereotype.Service;

import com.ddd.user.application.exception.UserNotFoundException;
import com.ddd.user.domain.model.UserModel;
import com.ddd.user.domain.ports.input.service.UserApplicationService;
import com.ddd.user.domain.ports.input.usecases.UserFinder;
import com.ddd.user.domain.ports.input.usecases.UserRegistration;
import com.ddd.user.domain.valueobject.UserEmail;
import com.ddd.user.domain.valueobject.UserName;
import com.ddd.user.domain.valueobject.UserPassword;
import com.ddd.user.domain.valueobject.UserUsername;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    
    private final UserFinder userFinder;
    private final UserRegistration userRegister;
    
    @Override
    public UserModel registerUser(String username, String name, String email, String password) {
        return userRegister.registerUser(new UserUsername(username), new UserName(name), new UserEmail(email), new UserPassword(password));
    }

    @Override
    public UserModel findUser(String username) {
        return userFinder.findUser(new UserUsername(username)).orElseThrow(() -> new UserNotFoundException("User with username " + username +  "not found"));
    }

    @Override
    public UserModel findUserByEmail(String email) {
        return userFinder.findUser(new UserEmail(email)).orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found"));
    }
    
}

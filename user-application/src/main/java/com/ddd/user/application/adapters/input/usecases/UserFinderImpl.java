package com.ddd.user.application.adapters.input.usecases;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ddd.user.domain.model.UserModel;
import com.ddd.user.domain.ports.input.usecases.UserFinder;
import com.ddd.user.domain.ports.output.repository.UserRepository;
import com.ddd.user.domain.valueobject.UserEmail;
import com.ddd.user.domain.valueobject.UserUsername;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserFinderImpl implements UserFinder {

    private final UserRepository userRepository;

    @Override
    public Optional<UserModel> findUser(UserUsername username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<UserModel> findUser(UserEmail email) {
        return userRepository.findByEmail(email);
    }
    
}

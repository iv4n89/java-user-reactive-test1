package com.ddd.user.application.adapters.input.usecases;

import com.ddd.user.domain.model.UserModel;
import com.ddd.user.domain.ports.input.usecases.UserRegistration;
import com.ddd.user.domain.ports.output.repository.UserRepository;
import com.ddd.user.domain.valueobject.UserEmail;
import com.ddd.user.domain.valueobject.UserName;
import com.ddd.user.domain.valueobject.UserPassword;
import com.ddd.user.domain.valueobject.UserUsername;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.ddd.shared.domain.valueobject.UserId;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public final class UserRegisterImpl implements UserRegistration {

    private final UserRepository userRepository;

    @Override
    public UserModel registerUser(UserUsername username, UserName name, UserEmail email, UserPassword password) {
        UserModel userModel = UserModel.builder()
                .id(new UserId(UUID.randomUUID()))
                .username(username)
                .name(name)
                .email(email)
                .password(password)
                .build();
        return userRepository.save(userModel);
    }
}

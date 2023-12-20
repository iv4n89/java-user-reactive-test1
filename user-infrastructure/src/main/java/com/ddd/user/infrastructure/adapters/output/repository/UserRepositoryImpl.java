package com.ddd.user.infrastructure.adapters.output.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ddd.user.domain.model.UserModel;
import com.ddd.user.domain.ports.output.repository.UserRepository;
import com.ddd.user.domain.valueobject.UserEmail;
import com.ddd.user.domain.valueobject.UserUsername;
import com.ddd.user.infrastructure.mapper.UserDataMapper;
import com.ddd.user.infrastructure.repository.UserJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public final class UserRepositoryImpl implements UserRepository {
    
    private final UserJpaRepository userJpaRepository;
    
    @Override
    public UserModel save(UserModel user) {
        return UserDataMapper.toDomain(userJpaRepository.save(UserDataMapper.toEntity(user)));
    }

    @Override
    public Optional<UserModel> findByUsername(UserUsername username) {
        return userJpaRepository.findByUsername(username.value()).map(UserDataMapper::toDomain);
    }

    @Override
    public Optional<UserModel> findByEmail(UserEmail email) {
        return userJpaRepository.findByEmail(email.value()).map(UserDataMapper::toDomain);
    }
    
}

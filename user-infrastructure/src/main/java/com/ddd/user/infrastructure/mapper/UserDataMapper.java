package com.ddd.user.infrastructure.mapper;

import org.ddd.shared.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import com.ddd.user.domain.model.UserModel;
import com.ddd.user.domain.valueobject.UserEmail;
import com.ddd.user.domain.valueobject.UserName;
import com.ddd.user.domain.valueobject.UserPassword;
import com.ddd.user.domain.valueobject.UserUsername;
import com.ddd.user.infrastructure.entity.UserEntity;

@Component
public final class UserDataMapper {

    private UserDataMapper() {
    }

    public static UserEntity toEntity(UserModel userModel) {
        return UserEntity.builder()
            .id(userModel.getId().value())
            .email(userModel.getEmail().value())
            .name(userModel.getName().value())
            .password(userModel.getPassword().value())
            .username(userModel.getUsername().value())
            .build();
    }

    public static UserModel toDomain(UserEntity userEntity) {
        return UserModel.builder()
            .id(new UserId(userEntity.getId()))
            .name(new UserName(userEntity.getName()))
            .email(new UserEmail(userEntity.getEmail()))
            .username(new UserUsername(userEntity.getUsername()))
            .password(new UserPassword(userEntity.getPassword()))
            .build();
    }
}

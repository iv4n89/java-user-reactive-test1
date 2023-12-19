package com.ddd.user.application.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class UserCreatorRequestDto {
    private final String username;
    private final String name;
    private final String email;
    private final String password;
}

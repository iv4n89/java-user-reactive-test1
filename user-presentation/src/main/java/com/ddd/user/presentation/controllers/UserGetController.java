package com.ddd.user.presentation.controllers;

import com.ddd.user.application.dto.UserResponseDto;
import com.ddd.user.domain.model.UserModel;
import com.ddd.user.domain.ports.input.service.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserGetController {

    private final UserApplicationService userApplicationService;

    @GetMapping("/username/{username}")
    public Mono<ResponseEntity<UserResponseDto>> getByUsername(@PathVariable String username) {
        return Mono.just(userApplicationService.findUser(username))
                .map(user -> UserResponseDto.builder()
                        .id(user.getId().value().toString())
                        .name(user.getName().value())
                        .username(user.getUsername().value())
                        .email(user.getEmail().value())
                        .password(user.getPassword().value())
                        .build())
                .map(ResponseEntity::ok)
                .onErrorResume(error -> Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/email/{email}")
    public Mono<ResponseEntity<UserResponseDto>> getByEmail(@PathVariable String email) {
        return Mono.just(userApplicationService.findUserByEmail(email))
                .map(user -> UserResponseDto.builder()
                        .id(user.getId().value().toString())
                        .name(user.getName().value())
                        .username(user.getUsername().value())
                        .email(user.getEmail().value())
                        .password(user.getPassword().value())
                        .build())
                .map(ResponseEntity::ok)
                .onErrorResume(error -> Mono.just(ResponseEntity.notFound().build()));
    }

}

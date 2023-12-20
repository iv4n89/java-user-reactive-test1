package com.ddd.user.presentation.controllers;

import com.ddd.user.application.dto.UserCreatorRequestDto;
import com.ddd.user.application.dto.UserResponseDto;
import com.ddd.user.domain.ports.input.service.UserApplicationService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserPostController {

    private final UserApplicationService userApplicationService;

    @PostMapping
    public Mono<ResponseEntity<UserResponseDto>> registrerUser(@RequestBody Mono<UserCreatorRequestDto> request) {
        return request
                .flatMap(r -> Mono.just(userApplicationService.registerUser(
                        r.getUsername(),
                        r.getName(),
                        r.getEmail(),
                        r.getPassword()
                ))).map(u -> UserResponseDto.builder().id(u.getId().value().toString()).name(u.getName().value()).username(u.getUsername().value()).email(u.getEmail().value()).build())
                .map(userResponseDto -> ResponseEntity.created(URI.create("/user")).body(userResponseDto))
                .onErrorResume(error -> Mono.just(ResponseEntity.badRequest().build()));
    }

}

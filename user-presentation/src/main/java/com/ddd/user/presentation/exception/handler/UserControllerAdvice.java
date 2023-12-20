package com.ddd.user.presentation.exception.handler;

import com.ddd.user.application.exception.UserNotFoundException;
import com.ddd.user.domain.exception.UserDomainException;
import lombok.extern.slf4j.Slf4j;
import org.ddd.shared.application.ErrorDto;
import org.ddd.shared.infrastructure.exception.handler.GlobalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class UserControllerAdvice extends GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UserDomainException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorDto handleException(UserDomainException exception) {
        log.error(exception.getMessage(), exception);

        return ErrorDto.builder()
                .code(HttpStatus.BAD_GATEWAY.getReasonPhrase())
                .message(exception.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleException(UserNotFoundException exception) {
        log.error(exception.getMessage(), exception);

        return ErrorDto.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(exception.getMessage())
                .build();
    }
}

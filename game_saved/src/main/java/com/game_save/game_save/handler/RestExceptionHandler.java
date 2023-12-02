package com.game_save.game_save.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.game_save.game_save.exception.noSuchFieldError;
import com.game_save.game_save.exception.noSuchFieldErrorDetails;
import com.game_save.game_save.exception.retryableExceptionDetails;

import feign.RetryableException;

@RestControllerAdvice
public class RestExceptionHandler extends  ResponseEntityExceptionHandler {
    
    @ExceptionHandler(NoSuchFieldError.class)
    public ResponseEntity<noSuchFieldErrorDetails> noSuchFieldError(noSuchFieldError nos){
        return new ResponseEntity<>(noSuchFieldErrorDetails.builder()
        .title("Save Not Found, check the API's database is ON")
        .status(HttpStatus.TEMPORARY_REDIRECT.value())
        .details(nos.getMessage())
        .developerMessage(nos.getClass().getName())
        .timestamp(LocalDateTime.now())
        .build()
        , HttpStatus.TEMPORARY_REDIRECT);
    }

    @ExceptionHandler(RetryableException.class)
    public ResponseEntity<retryableExceptionDetails> retryableException( RetryableException retr){
        return new ResponseEntity<retryableExceptionDetails>(retryableExceptionDetails.builder()
        .title("Game Not Found, check the API's database is ON")
        .status(HttpStatus.BAD_REQUEST.value())
        .details(retr.getMessage())
        .developerMessage(retr.getClass().getName())
        .timestamp(LocalDateTime.now())
        .build(), HttpStatus.BAD_REQUEST);
    }
}

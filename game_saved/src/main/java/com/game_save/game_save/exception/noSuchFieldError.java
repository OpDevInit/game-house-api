package com.game_save.game_save.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
public class noSuchFieldError extends NoSuchFieldError {
    
    public noSuchFieldError(String s){
        super(s);
    }
}

package com.ja.resapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccounNotFoundException extends RuntimeException {

    public AccounNotFoundException(String param) {
        super("could not user '" + param + "'.");
    }
}

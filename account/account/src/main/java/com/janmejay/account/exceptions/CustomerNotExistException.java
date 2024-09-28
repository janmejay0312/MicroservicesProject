package com.janmejay.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND)
public class CustomerNotExistException extends  RuntimeException {

    public CustomerNotExistException(String message) {
        super(message);
    }
}

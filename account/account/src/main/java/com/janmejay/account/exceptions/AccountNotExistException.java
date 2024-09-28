package com.janmejay.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND)
public class AccountNotExistException extends RuntimeException{

    public AccountNotExistException(String message){
        super(message);
    }
}

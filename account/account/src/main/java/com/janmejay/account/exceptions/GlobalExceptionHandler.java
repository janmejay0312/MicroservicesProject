package com.janmejay.account.exceptions;

import com.janmejay.account.dto.ErrorResponseDto;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDto> handlerCustomerAlreadyExistException(CustomerAlreadyExistException exception, WebRequest webRequest){

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.BAD_REQUEST,exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotExistException.class)
    public ResponseEntity<ErrorResponseDto> handlerCustomerNotExistException(CustomerNotExistException exception, WebRequest webRequest){

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.NOT_FOUND,exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountNotExistException.class)
    public ResponseEntity<ErrorResponseDto> handlerAccountAlreadyExistException(AccountNotExistException exception, WebRequest webRequest){

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.NOT_FOUND,exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handlerResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.NOT_FOUND,exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handlerResourceNotFoundException(Exception exception, WebRequest webRequest){

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}

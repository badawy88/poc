package com.muntanji.velocitydemo.registration.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.ws.rs.BadRequestException;

public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> handleBadRequest() {
        ApiError error = new ApiError("" , HttpStatus.BAD_GATEWAY , "");
        return new ResponseEntity("" , new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}

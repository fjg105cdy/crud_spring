package com.yian.crud_spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotfoundException extends RuntimeException {
    public ResourceNotfoundException(String message,String fieldName,Object fieldValue) {
        super(String.format("%s with %s: %s not found",message,fieldName,fieldValue));
    }
}

package com.app.api.exception;

import lombok.Getter;

/**
 * @author Anish Panthi
 */
@Getter
public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}

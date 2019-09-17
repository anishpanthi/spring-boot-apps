package com.app.api.exception;

import lombok.Getter;
import org.springframework.validation.Errors;

/**
 * @author Anish Panthi
 */
@Getter
public class DataException extends RuntimeException {

    private final Errors errors;

    public DataException(String message, Errors errors){
        super(message);
        this.errors = errors;
    }
}

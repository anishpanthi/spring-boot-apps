package com.app.api.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Anish Panthi
 */
public class JwtTokenMalformedException extends AuthenticationException {

    /**
     * @param msg
     */
    public JwtTokenMalformedException(String msg) {
        super(msg);
    }

}

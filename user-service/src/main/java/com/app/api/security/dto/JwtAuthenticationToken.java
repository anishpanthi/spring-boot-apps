package com.app.api.security.dto;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author Anish Panthi
 */
@Getter
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private final String token;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
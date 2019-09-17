package com.app.api.security.util;

import com.app.api.security.dto.JwtUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @author Anish Panthi
 */
public class JwtTokenGenerator {

    public static String generateToken(JwtUserDto u, String secret) {
        final Date expirationDate = new Date(System.currentTimeMillis() + (2 * 24 * 60 * 60 * 1000));


        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("userId", u.getId());
        claims.put("role", u.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(signatureAlgorithm, signingKey)
                .compact();
    }
}

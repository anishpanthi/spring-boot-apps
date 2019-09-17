package com.app.api.security;

import com.app.api.annotation.EnableEscapeForCGLibProxy;
import com.app.api.security.dto.JwtAuthenticationToken;
import com.app.api.security.exception.JwtTokenMissingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anish Panthi
 */
@Slf4j
@EnableEscapeForCGLibProxy
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    @Value("${jwt.header}")
    private String tokenHeader;

    private static final List<RequestMatcher> PATHS = Arrays.asList(
            new AntPathRequestMatcher("/v1/users/**")
    );

    public JwtAuthenticationTokenFilter() {
        super(new OrRequestMatcher(PATHS));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        String header = request.getHeader(this.tokenHeader);

        String authToken;

        if (header != null && header.startsWith("Bearer ")) {
            authToken = header.substring(7);
        } else {
            throw new JwtTokenMissingException("No JWT token found in request headers");
        }

        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

        return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        log.info("Authenticated User: {}", authResult.getPrincipal());
        // As this authentication is in HTTP header, after success we need to continue the request normally
        // and return the response as if the resource was not secured at all
        chain.doFilter(request, response);
    }
}

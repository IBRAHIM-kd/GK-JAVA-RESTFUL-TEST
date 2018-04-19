package org.cca.com.GKJAVARESTFULTEST.config;

import org.cca.com.GKJAVARESTFULTEST.domain.UserDetail;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static org.cca.com.GKJAVARESTFULTEST.config.SecurityConstants.EXPIRATION_TIME;
import static org.cca.com.GKJAVARESTFULTEST.config.SecurityConstants.HEADER_STRING;
import static org.cca.com.GKJAVARESTFULTEST.config.SecurityConstants.SECRET;
import static org.cca.com.GKJAVARESTFULTEST.config.SecurityConstants.TOKEN_PREFIX;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
        	UserDetail creds = new ObjectMapper()
                    .readValue(req.getInputStream(), UserDetail.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

    	Date expiration = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
    	String token = Jwts.builder().setSubject(((User) auth.getPrincipal()).getUsername())
    	        .setExpiration(expiration)
    	        .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    	  
    	res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}
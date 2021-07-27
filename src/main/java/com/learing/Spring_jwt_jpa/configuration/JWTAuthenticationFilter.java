package com.learing.Spring_jwt_jpa.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learing.Spring_jwt_jpa.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

//We are writing custom Authentication logic
//UsernamePasswordAuthenticationFilter which is the default class for password authentication in Spring Security
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

// Calling setFilterProcessesUrl method in our constructor.
// This method sets the default login URL to the provided parameter
// If you remove this line, Spring Security creates the “/login” endpoint by default.
        setFilterProcessesUrl(SecurityConstants.SIGN_UP_URL);
    }

    //We override the attemptAuthentication and successfulAuthentication methods of the UsernameAuthenticationFilter class.

    /**
     * The attemptAuthentication function runs when the user tries to login to our application.
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            //It reads the credentials,creates a user POJO from them, and then checks the credentials to authenticate
            User cred = new ObjectMapper().readValue(request.getInputStream(), User.class);

            //We pass the username, password, and an empty list. The empty list represents the authorities (roles)
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            cred.getUserName(),
                            cred.getPassword(),
                            new ArrayList<>()
                    )
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * If the authentication is successful, the successfulAuthentication method runs.
     * The parameters of this method are passed by Spring Security behind the scenes.
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        //We want to return a token to user after authentication is successful,
        // so we create the token using username, secret, and expiration date.
        // We need to define the SECRET and EXPIRATION_DATE now.
        String token = JWT.create()
                .withSubject(((User) authResult.getPrincipal()).getUserName())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));

        String body = ((User) authResult.getPrincipal()).getUserName() + " " + token;

        response.getWriter().write(body);
        response.getWriter().flush();
    }
}

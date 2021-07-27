package com.learing.Spring_jwt_jpa.configuration;

public class SecurityConstants {

    public static final String SECRET = "SECRET_KEY";
    //The expiration time is set to 15 minutes,
    // because it is the best practice against secret key brute-forcing attacks. The time is in milliseconds.
    public static final long EXPIRATION_TIME = 900_000; // 15 mins
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/users/signup";
}


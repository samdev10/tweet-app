package com.tweet.security.jwt;

public class InvalidJwtAuthenticationException extends Exception {
    public InvalidJwtAuthenticationException(String message) {
        super(message);
    }
}

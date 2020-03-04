package com.tweet.security.jwt;

/**
 * InvalidJwtAuthenticationException.
 */
public class InvalidJwtAuthenticationException extends Exception {
    /**
     * @param message the error message
     */
    public InvalidJwtAuthenticationException(final String message) {
        super(message);
    }
}

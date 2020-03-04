package com.tweet.security.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JwtTokenProvider.
 */
@Component
public class JwtTokenProvider {
    private static final int SUB_STRING_LENGTH = 7;
    private static final int TIMEOUT_IN_SECS = 3600000;

    @Value("${security.jwt.token.secret-key:secret}")
    private String secretKey = "secret";

    @Value("${security.jwt.token.expire-length:3600000}") // 1h
    private long validityInMilliseconds = TIMEOUT_IN_SECS;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * init
     */
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder()
                          .encodeToString(secretKey.getBytes());
    }

    /**
     * @param username the username
     * @param roles the roles
     * @return a token
     */
    public String createToken(final String username, final List<String> roles) {

        Claims claims = Jwts.claims()
                            .setSubject(username);
        claims.put("roles", roles);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()//
                   .setClaims(claims)//
                   .setIssuedAt(now)//
                   .setExpiration(validity)//
                   .signWith(SignatureAlgorithm.HS256, secretKey)//
                   .compact();
    }

    /**
     * @param token the token
     * @return the authentication
     */
    public Authentication getAuthentication(final String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    /**
     * @param token the token
     * @return the username
     */
    public String getUsername(final String token) {
        return Jwts.parser()
                   .setSigningKey(secretKey)
                   .parseClaimsJws(token)
                   .getBody()
                   .getSubject();
    }

    /**
     * @param req the request
     * @return the token
     */
    public String resolveToken(final HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(SUB_STRING_LENGTH, bearerToken.length()); // NOPMD
        }
        return null;
    }

    /**
     * @param token the token
     * @return true if the token is valid
     * @throws Exception
     */
    public boolean validateToken(final String token) throws Exception {
        try {
            Jws<Claims> claims = Jwts.parser()
                                     .setSigningKey(secretKey)
                                     .parseClaimsJws(token);

            if (claims.getBody()
                      .getExpiration()
                      .before(new Date())) {
                return false;
            }

            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
        }
    }

}

package com.tweet.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 * JwtTokenFilter.
 */
public class JwtTokenFilter extends GenericFilterBean {

    private JwtTokenProvider jwtTokenProvider;

    /**
     * @param jwtTokenProvider the JwtTokenProvider.
     */
    public JwtTokenFilter(final JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain filterChain)
            throws IOException, ServletException {

        String token = jwtTokenProvider.resolveToken((HttpServletRequest) req);
        try {
            if (token != null && jwtTokenProvider.validateToken(token)) {
                Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;
                SecurityContextHolder.getContext()
                                     .setAuthentication(auth);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        filterChain.doFilter(req, res);
    }

}


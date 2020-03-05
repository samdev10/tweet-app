package com.tweet.security.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LogoutController.
 */
@RestController
public class LogoutController {
    /**
     * @param request the request.
     * @param response the response.
     */
    @PostMapping("/signout")
    public void signout(final HttpServletRequest request, final HttpServletResponse response) {
        final Cookie token = new Cookie("token", null);
        final Cookie username = new Cookie("username", null);
        final Cookie jsession = new Cookie("JSESSIONID", null);
        final String cookiePath = request.getContextPath() + "/";

        token.setPath(cookiePath);
        token.setMaxAge(0);
        response.addCookie(token);

        username.setPath(cookiePath);
        username.setMaxAge(0);
        response.addCookie(username);

        jsession.setPath(cookiePath);
        jsession.setMaxAge(0);
        response.addCookie(jsession);
    }
}

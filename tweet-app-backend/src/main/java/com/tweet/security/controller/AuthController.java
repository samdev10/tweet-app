package com.tweet.security.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.repository.UserInfoRepository;
import com.tweet.security.bo.AuthenticationRequest;
import com.tweet.security.jwt.JwtTokenProvider;

/**
 * Auth Controller.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private transient AuthenticationManager authenticationManager;
    @Autowired
    private transient JwtTokenProvider jwtTokenProvider;
    @Autowired
    private transient UserInfoRepository userRepo;


    /**
     * @param data the auth request
     * @return response
     */
    @PostMapping(value = "/signin", produces = "application/json")
    public ResponseEntity<Map<Object, String>> signin(@RequestBody final AuthenticationRequest data) {
        try {
            String username = data.getUsername();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.createToken(username, Optional.of(userRepo.findByUsername(username))
                                                                            .orElseThrow(
                                                                                    () -> new UsernameNotFoundException(
                                                                                            "Username " + username
                                                                                                    + "not found"))
                                                                            .getRoles());

            Map<Object, String> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}

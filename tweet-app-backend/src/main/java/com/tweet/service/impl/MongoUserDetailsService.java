package com.tweet.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tweet.bo.UserInfo;
import com.tweet.repository.UserInfoRepository;

/**
 * MongoUserDetailsService.
 */
@Component
public class MongoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public User loadUserByUsername(final String username) throws UsernameNotFoundException {
        final UserInfo user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        final List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("USER"));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

}

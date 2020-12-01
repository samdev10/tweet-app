package com.tweet.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tweet.bo.UserInfo;
import com.tweet.repository.UserInfoRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;

/**
 * UserInfoResolver.
 */
@Component
public class UserInfoResolver implements GraphQLQueryResolver {
    @Autowired
    private transient UserInfoRepository userRepo;

    /**
     * @return a list of user info
     */
    public UserInfo getUserInfo(final String username) {
        return userRepo.findByUsername(username);
    }
}

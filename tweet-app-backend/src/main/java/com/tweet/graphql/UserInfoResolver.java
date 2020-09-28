package com.tweet.graphql;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tweet.bo.UserInfo;

import graphql.kickstart.tools.GraphQLQueryResolver;

/**
 * UserInfoResolver.
 */
@Component
public class UserInfoResolver implements GraphQLQueryResolver {
    /**
     * @return a list of user info
     */
    public List<UserInfo> getUserInfo() {
        return asList(UserInfo.builder()
                              .username("sam")
                              .emailId("sam@gmail.com")
                              .build());
    }
}

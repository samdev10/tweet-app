package com.tweet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweet.bo.UserInfo;

/**
 * User Information Repository.
 */
public interface UserInfoRepository extends MongoRepository<UserInfo, Long> {
    /**
     * @param userName the userName.
     * @return the user information.
     */
    UserInfo findByUsername(String username);
}; // NOPMD

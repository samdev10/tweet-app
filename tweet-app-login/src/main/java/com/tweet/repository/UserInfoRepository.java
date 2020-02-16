package com.tweet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweet.bo.UserInfo;

/**
 * User Information Repository.
 */
public interface UserInfoRepository extends MongoRepository<UserInfo, Long> {
}; // NOPMD

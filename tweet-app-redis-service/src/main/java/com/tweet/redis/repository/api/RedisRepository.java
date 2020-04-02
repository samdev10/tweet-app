package com.tweet.redis.repository.api;

import java.util.Map;

import com.tweet.bo.redis.User;

public interface RedisRepository {
    Map<Long, User> findAll();

    void save(final User user);
}

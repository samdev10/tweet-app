package com.tweet.redis.repository.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.tweet.bo.redis.User;
import com.tweet.redis.repository.api.RedisRepository;

@Repository
public class UserRepository implements RedisRepository {
    private HashOperations<String, Long, User> hashOpertions;

    public UserRepository(@Autowired final RedisTemplate<String, Object> redisTemplate) {
        hashOpertions = redisTemplate.opsForHash();
    }

    @Override
    public Map<Long, User> findAll() {
        return hashOpertions.entries("USER");
    }

    @Override
    public void save(final User user) {
        hashOpertions.put("USER", user.getId(), user);
    }

}

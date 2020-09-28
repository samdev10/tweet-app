package com.tweet.redis.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tweet.bo.redis.User;
import com.tweet.redis.AbstractRedisTest;
import com.tweet.redis.repository.impl.UserRepository;

public class UserRepositoryIntegrationTest extends AbstractRedisTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldSaveUser_toRedis() {
        UUID id = UUID.randomUUID();
        User user = User.builder()
                        .id(1L)
                        .userName("Sam")
                        .build();

        userRepository.save(user);

        assertThat(userRepository.findAll()
                                 .values()).contains(user);
    }
}

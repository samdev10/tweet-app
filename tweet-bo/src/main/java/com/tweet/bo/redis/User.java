package com.tweet.bo.redis;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("User")
public class User implements Serializable {
    private Long id;
    private String userName;
}

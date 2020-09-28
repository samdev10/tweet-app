package com.tweet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.oembedler.moon.graphql.boot.GraphQLWebsocketAutoConfiguration;
import com.tweet.configuration.RedisConfiguration;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.tweet")
@Import({ RedisConfiguration.class })
@EnableAutoConfiguration(exclude = { GraphQLWebsocketAutoConfiguration.class })
public class TweetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TweetApplication.class, args);
    }

}


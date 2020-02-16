package com.tweet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.tweet.data.config.MongoConfig;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.tweet")
@Import({ MongoConfig.class })
public class TweetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TweetApplication.class, args);
    }

}


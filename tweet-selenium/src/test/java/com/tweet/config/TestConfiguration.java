package com.tweet.config;

import static com.tweet.selenium.SeleniumDriver.getInstance;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tweet.test.TweetApp;

@Configuration
public class TestConfiguration {
    @Value("${tweet.app.url}")
    private String url;

    @Bean
    public TweetApp tweetApp() {
        return new TweetApp(getInstance(), url);
    }
}

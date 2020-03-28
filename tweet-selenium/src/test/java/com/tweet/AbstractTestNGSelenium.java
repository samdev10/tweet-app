package com.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;

import com.tweet.config.TestConfiguration;
import com.tweet.data.config.MongoConfig;
import com.tweet.repository.UserInfoRepository;
import com.tweet.test.TweetApp;
import com.tweet.utill.SequenceGeneratorService;

@ContextConfiguration(classes = { MongoConfig.class, TestConfiguration.class })
@TestPropertySource("classpath:application-test.properties")
@EnableMongoRepositories(basePackages = "com.tweet.repository")
public class AbstractTestNGSelenium extends AbstractTestNGSpringContextTests {
    @Autowired
    protected UserInfoRepository userInfoRepository;

    @Autowired
    private TweetApp tweetApp;

    @Autowired
    private MongoTemplate mongoTemplate;

    protected SequenceGeneratorService sequenceGenerator;

    protected TweetApp tweetApp() {
        return tweetApp;
    }

    protected SequenceGeneratorService sequenceGenerator() {
        return new SequenceGeneratorService(mongoTemplate);
    }

    @AfterSuite
    public void close() {
        tweetApp.close();
    }
}

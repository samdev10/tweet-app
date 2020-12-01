package com.tweet;

import static com.tweet.bo.UserInfo.SEQUENCE_NAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

import com.tweet.bo.UserInfo;
import com.tweet.config.TestConfiguration;
import com.tweet.data.config.MongoConfig;
import com.tweet.data.config.MongoDevConfig;
import com.tweet.repository.UserInfoRepository;
import com.tweet.test.TweetApp;
import com.tweet.test.util.TweetAppUser;
import com.tweet.utill.SequenceGeneratorService;

@ContextConfiguration(classes = { MongoConfig.class, MongoDevConfig.class, TestConfiguration.class })
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

    protected void createUserInfo(final TweetAppUser user) {
        final Long sequenceNumber = sequenceGenerator().generateSequence(SEQUENCE_NAME);
        final UserInfo userInfo = UserInfo.builder()
                                          .id(sequenceNumber)
                                          .username(user.getUsername())
                                          .firstname(user.getFirstname())
                                          .lastname(user.getLastname())
                                          .password(user.getPassword())
                                          .emailId(user.getEmailid())
                                          .build();
        userInfoRepository.save(userInfo);
    }

    @BeforeMethod
    public void before() {
        tweetApp.logout();
    }
}

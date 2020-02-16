package com.tweet.repository;

import static com.tweet.bo.UserInfo.SEQUENCE_NAME;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tweet.bo.UserInfo;
import com.tweet.data.config.MongoConfig;
import com.tweet.utill.SequenceGeneratorService;

@RunWith(SpringRunner.class)
@EnableMongoRepositories
@DataMongoTest
@ContextConfiguration(classes = MongoConfig.class, initializers = ConfigFileApplicationContextInitializer.class)
public class UserInfoRepositoryTest {
    @Autowired
    private UserInfoRepository uut;
    @Autowired
    private MongoTemplate mongoTemplate;
    private UserInfo userInfo;
    private SequenceGeneratorService sequenceGenerator;

    @Before
    public void setUp() {
        sequenceGenerator = new SequenceGeneratorService(mongoTemplate);
        userInfo = UserInfo.builder()
                           .id(sequenceGenerator.generateSequence(SEQUENCE_NAME))
                .userName("sam")
                .emailId("sam@me.com")
                           .build();
        uut.save(userInfo);
    }

    @Test
    public void shouldSaveTheUserInfo() {
        // When
        List<UserInfo> result = uut.findAll();

        // Then
        assertThat(result).contains(userInfo);
    }

    @Test
    public void shouldfindUserInfo() {
        // When
        final UserInfo result = uut.findById(userInfo.getId())
                                         .get();

        // Then
        assertThat(result).isEqualTo(userInfo);
    }
}

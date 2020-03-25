package com.tweet.repository;

import static com.tweet.bo.UserInfo.SEQUENCE_NAME;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.tweet.bo.UserInfo;
import com.tweet.data.config.MongoConfig;
import com.tweet.utill.SequenceGeneratorService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoConfig.class)
@EnableMongoRepositories
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
        final Long sequenceNumber = sequenceGenerator.generateSequence(SEQUENCE_NAME);
        userInfo = UserInfo.builder()
                           .id(sequenceNumber)
                           .userName("sam" + sequenceNumber)
                           .emailId("sam@me.com")
                           .password("password")
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

    @Test
    public void shouldfindByUserId() {
        // When
        final UserInfo result = uut.findByUserName(userInfo.getUserName());

        // Then
        assertThat(result).isEqualTo(userInfo);
    }
}

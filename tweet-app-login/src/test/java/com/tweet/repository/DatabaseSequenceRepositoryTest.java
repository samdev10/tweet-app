package com.tweet.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tweet.bo.DatabaseSequence;
import com.tweet.data.config.MongoConfig;

@RunWith(SpringRunner.class)
@EnableMongoRepositories
@DataMongoTest
@ContextConfiguration(classes = MongoConfig.class, initializers = ConfigFileApplicationContextInitializer.class)
public class DatabaseSequenceRepositoryTest {
    @Autowired
    private DatabaseSequenceRepository uut;

    @Test
    public void shouldSaveTheDataSequence() {
        // Given
        final DatabaseSequence databaseSequence = DatabaseSequence.builder()
                                                                  .id("11")
                                                                  .seq(2L)
                                                                  .build();
        // When
        final DatabaseSequence result = uut.save(databaseSequence);

        // Then
        assertThat(result.getId()).isEqualTo("11");
    }
}

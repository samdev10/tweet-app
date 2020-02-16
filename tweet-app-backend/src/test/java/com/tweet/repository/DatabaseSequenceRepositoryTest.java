package com.tweet.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.tweet.bo.DatabaseSequence;

@DataMongoTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.tweet")
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

package com.tweet.utill;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.tweet.bo.DatabaseSequence;

/**
 * Sequence Generator Service.
 *
 * */
@Component
public class SequenceGeneratorService {
    private final transient MongoTemplate mongoTemplate;

    /**
     * @param mongoTemplate the mongotemplate.
     */
    @Autowired
    public SequenceGeneratorService(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * @param seqName the seqName.
     * @return the next sequence number.
     */
    public Long generateSequence(final String seqName) {
        DatabaseSequence counter = mongoTemplate.findAndModify(new Query(where("id").is(seqName)),
                new Update().inc("seq", 1), FindAndModifyOptions.options()
                                                                .returnNew(true)
                                                                .upsert(true),
                DatabaseSequence.class);
        if (Objects.isNull(counter)) {
            counter = DatabaseSequence.builder()
                                      .seq(1L)
                                      .id(seqName)
                                      .build();
        }
        mongoTemplate.save(counter);
        return counter.getSeq();
    }
}

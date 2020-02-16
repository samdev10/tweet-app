package com.tweet.bo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Database Sequence.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "database_sequences")
public class DatabaseSequence {
    @MongoId
    private String id;
    private Long seq;
}

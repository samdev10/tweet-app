package com.tweet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweet.bo.DatabaseSequence;

/**
 * Database Sequence Repository.
 */
public interface DatabaseSequenceRepository extends MongoRepository<DatabaseSequence, String> {
}; // NOPMD


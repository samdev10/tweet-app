package com.tweet.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

/**
 * Mongo Config.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    /*
     * {@inheritDoc}
     */
    @Override
    protected String getDatabaseName() {
        return "tweet-app";
    }

    /*
     * {@inheritDoc}
     */
    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost");
    }

    /*
     * {@inheritDoc}
     */
    @Override
    protected String getMappingBasePackage() {
        return "com.tweet";
    }
}

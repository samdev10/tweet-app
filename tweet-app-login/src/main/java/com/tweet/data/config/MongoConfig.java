package com.tweet.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

/**
 * Mongo Config.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${datasource.client:localhost}")
    private String client;

    @Value("${datasource.database:tweet-app}")
    private String databaseName;

    /*
     * {@inheritDoc}
     */
    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    /*
     * {@inheritDoc}
     */
    @Override
    public MongoClient mongoClient() {
        return new MongoClient(client);
    }

    /*
     * {@inheritDoc}
     */
    @Override
    protected String getMappingBasePackage() {
        return "com.tweet";
    }
}

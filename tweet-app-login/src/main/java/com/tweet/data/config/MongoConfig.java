package com.tweet.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * Mongo Config.
 */
@Configuration
@Profile("!dev")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${mongodb.local.database.name:tweet-app}")
    private String databaseName;

    @Value("${mongodb.local.host.name:localhost}")
    private String host;

    @Value("${mongodb.local.host.port:27017}")
    private String port;

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
        return MongoClients.create("mongodb://" + host + ":" + port + "/");
    }

}

package com.tweet.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * Mongo Config.
 */
@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

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
        return MongoClients.create("mongodb://" + client + ":27017/?replicaSet=rs0&w=majority");
    }
}

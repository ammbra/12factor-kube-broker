package com.acme.demo.broker;
import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;

@Configuration
public class DatabaseConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfig.class);


    public static final String URL = "url";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String DATABASE_NAME = "dream-homes";

    @Value("${spring.cloud.kubernetes.dbsecret}")
    String databaseCredentials;


    @Bean
    public Database cloudantclient() {
        Database db = null;
        try {
            JSONObject credentials = new JSONObject(databaseCredentials);
            CloudantClient client = ClientBuilder.url(new URL(credentials.get(URL).toString()))
                    .username(credentials.get(USERNAME).toString()).password(credentials.get(PASSWORD).toString())
                    .build();
            db = client.database(DATABASE_NAME, true);
        } catch (Exception e) {
            LOGGER.error("Exception while to database with credentials {} : {}", databaseCredentials, e);
        }

        return db;
    }

}

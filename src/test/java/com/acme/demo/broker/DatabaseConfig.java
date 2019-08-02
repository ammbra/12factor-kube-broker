package com.acme.demo.broker;

import java.net.URL;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

@Configuration
public class DatabaseConfig {

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
            e.printStackTrace();
        }

        return db;
    }

}

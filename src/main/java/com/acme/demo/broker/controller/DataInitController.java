package com.acme.demo.broker.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Document;
import com.cloudant.client.api.model.Response;


/**
 * @author Ana Maria
 */
@RestController
@RequestMapping("/rest/init")
@PropertySource(value = "classpath:init.json")
public class DataInitController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataInitController.class);

    @Autowired
    private Database repo;

    @Value("${content}")
    String content;

    @RequestMapping(method = RequestMethod.GET)
    public List<Response> initAll() throws SQLException, IOException {
        List<Response> responses = new ArrayList<>();
        List<Object> documents = new JSONArray(content).toList();
        for (Object document : documents) {
            responses.add(repo.post(document));
        }

        return responses;

    }

    @RequestMapping(value = "/empty", method = RequestMethod.GET)
    public void emptyDatabase() throws IOException {
        List<Document> docs = repo.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocs();
        for (Document doc : docs)
            repo.remove(doc.getId(), doc.getRevision());
    }

}

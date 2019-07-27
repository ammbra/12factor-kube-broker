package com.acme.demo.broker.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acme.demo.broker.model.Broker;
import com.cloudant.client.api.Database;

/**
 * @author Ana Maria
 */
@RestController
@RequestMapping("/broker")
public class BrokerController {

    public static final String SELECTOR_JSON = " \"selector\": { \"email\": {\"$ne\": \"null\"} }";

    @Autowired
    private Database repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Broker> getAll() throws IOException {
        return repo.findByIndex(SELECTOR_JSON, Broker.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Broker get(@PathVariable String id) {
        return repo.find(Broker.class, id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int create(@RequestBody Broker broker) {
        return repo.post(broker).getStatusCode();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}/{rev}")
    public void delete(@PathVariable String id, @PathVariable String rev) {
        repo.remove(id, rev);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public int update(@RequestBody Broker broker) {
        return repo.update(broker).getStatusCode();
    }
}
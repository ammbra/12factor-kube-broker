package com.acme.demo.broker.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acme.demo.broker.model.Contract;
import com.cloudant.client.api.Database;

/**
 * @author Ana Maria
 */
@RestController
@RequestMapping("/contract")
public class ContractController {

    public static final String SELECTOR_JSON = " \"selector\": { \"value\": {\"$gt\": 0} }";
    @Autowired
    private Database repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Contract> getAll() throws IOException {
        return repo.findByIndex(SELECTOR_JSON, Contract.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Contract get(@PathVariable String id) {
        return repo.find(Contract.class, id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int create(@RequestBody Contract contract) {
        return repo.post(contract).getStatusCode();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}/{rev}")
    public void delete(@PathVariable String id, @PathVariable String rev) {
        repo.remove(id, rev);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public int update(@RequestBody Contract contract) {
        return repo.update(contract).getStatusCode();
    }
}
package com.acme.demo.broker.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.acme.demo.broker.App;
import com.acme.demo.broker.controller.BrokerController;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = { com.acme.demo.broker.DatabaseConfig.class, App.class })
@TestPropertySource(locations = "classpath:application.properties")
public class BrokerControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private BrokerController service;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void init() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void getAllBrokers() throws Exception {
		mvc.perform(get("/broker").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}

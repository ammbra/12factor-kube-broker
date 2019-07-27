package com.acme.demo.broker;

import com.acme.demo.broker.controller.BrokerController;
import com.acme.demo.broker.controller.ContractController;
import com.acme.demo.broker.controller.DataInitController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Ana Maria
 */
@ComponentScan
@SpringBootApplication(scanBasePackageClasses = { BrokerController.class, DataInitController.class,
		ContractController.class, SwaggerConfig.class })
public class App extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

}

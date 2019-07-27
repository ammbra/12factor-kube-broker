package com.acme.demo.broker.model;

/**
 *
 * @author Ana Maria
 */
public final class DataUtility {

	private DataUtility() {
		super();
	}

	public static final Broker[] BROKERS = { new Broker("Ms", "Broker Name1", "000417136864", "brokername1@bn1.com"),
			new Broker("Mr", "Chris Anderson", "3274175955", null),
			new Broker("Ms", "Broker Name2", "73517947559260", "brokername2@bn1.com") };

}

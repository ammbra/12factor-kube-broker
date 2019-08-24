package com.acme.demo.broker.model;

import java.math.BigDecimal;

/**
 *
 * @author Ana Maria
 */
public class Money {

	enum Currency {
		CAD, EUR, USD
	}

	private BigDecimal amount;

	private Currency currency;

	public Money(BigDecimal amount) {
		this(Currency.USD, amount);
	}

	Money(Currency currency, BigDecimal amount) {
		this.currency = currency;
		this.amount = amount;
	}
}
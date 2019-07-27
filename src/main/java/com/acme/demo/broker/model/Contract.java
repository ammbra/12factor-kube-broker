package com.acme.demo.broker.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Ana Maria
 */
public class Contract {

	private String _id;

	private String _rev;
	
	private Date transactionDate;

	private TransactionType transactionType;

	private String customerId;

	private String brokerId;
	
	private String type;
	
	@JsonIgnore
	private Money value;

	public Contract() {
	}

	public Contract(Date transactionDate, TransactionType transactionType, String customerId, String brokerId, Money value) {
		super();
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.customerId = customerId;
		this.brokerId = brokerId;
		this.value = value;
		this.type = "contract";
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	
	public String get_rev() {
		return _rev;
	}

	public void set_rev(String _rev) {
		this._rev = _rev;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	public Money getValue() {
		return value;
	}

	public void setValue(Money value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (_id != null ? _id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Contract)) {
			return false;
		}
		Contract other = (Contract) object;
		if ((this._id == null && other._id != null) || (this._id != null && !this._id.equals(other._id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Contract [_id=" + _id + ", _rev=" + _rev + ", transactionDate=" + transactionDate + ", transactionType="
				+ transactionType + ", customerId=" + customerId + ", brokerId=" + brokerId + ", type=" + type
				+ ", value=" + value + "]";
	}

	

}

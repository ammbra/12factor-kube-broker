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
		if (!(object instanceof Contract)) {
			return false;
		}
		Contract other = (Contract) object;
		if ((this._id == null && other._id != null) || (this._id != null && !this._id.equals(other._id))) {
			return false;
		}
		return true;
	}


	@java.lang.Override
	public java.lang.String toString() {
		final java.lang.StringBuffer sb = new java.lang.StringBuffer("Contract{");
		sb.append("_id='").append(_id).append('\'');
		sb.append(", _rev='").append(_rev).append('\'');
		sb.append(", transactionDate=").append(transactionDate);
		sb.append(", transactionType=").append(transactionType);
		sb.append(", customerId='").append(customerId).append('\'');
		sb.append(", brokerId='").append(brokerId).append('\'');
		sb.append(", type='").append(type).append('\'');
		sb.append(", value=").append(value);
		sb.append('}');
		return sb.toString();
	}
}

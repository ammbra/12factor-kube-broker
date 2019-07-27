package com.acme.demo.broker.model;

/**
 *
 * @author Ana Maria
 */
public class Broker {

	private String _id;

	private String _rev;

	private String title;

	private String brokerName;

	private String mobilePhone;
	
	private String email;
	
	private String type;

	public Broker() {
	}

	public Broker(String bookId) {
		this._id = bookId;
	}

	
	public Broker(String title, String brokerName, String mobilePhone, String email) {
		super();
		this.title = title;
		this.brokerName = brokerName;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.type = "broker";
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

		if (!(object instanceof Broker)) {
			return false;
		}

		Broker other = (Broker) object;
		if ((this._id == null && other._id != null) || (this._id != null && !this._id.equals(other._id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Broker [_id=" + _id + ", _rev=" + _rev + ", title=" + title + ", brokerName=" + brokerName
				+ ", mobilePhone=" + mobilePhone + ", email=" + email + ", type=" + type + "]";
	}


}

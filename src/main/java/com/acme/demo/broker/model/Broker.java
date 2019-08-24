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
		if (!(object instanceof Broker)) {
			return false;
		}

		Broker other = (Broker) object;
		if ((this._id == null && other._id != null) || (this._id != null && !this._id.equals(other._id))) {
			return false;
		}
		return true;
	}


	@java.lang.Override
	public java.lang.String toString() {
		final java.lang.StringBuffer sb = new java.lang.StringBuffer("Broker{");
		sb.append("_id='").append(_id).append('\'');
		sb.append(", _rev='").append(_rev).append('\'');
		sb.append(", title='").append(title).append('\'');
		sb.append(", brokerName='").append(brokerName).append('\'');
		sb.append(", mobilePhone='").append(mobilePhone).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", type='").append(type).append('\'');
		sb.append('}');
		return sb.toString();
	}
}

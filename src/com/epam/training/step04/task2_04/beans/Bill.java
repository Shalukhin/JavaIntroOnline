package com.epam.training.step04.task2_04.beans;

import java.util.Date;

public class Bill {

	private String number;
	private String clientId;
	private Date dateCreation;
	private long balance;
	private boolean active;

	public Bill() {
		super();
		dateCreation = new Date();
	}

	public Bill(String number, String clientId, long balance, boolean active) {
		super();
		this.number = number;
		this.clientId = clientId;
		this.balance = balance;
		this.active = active;
		dateCreation = new Date();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getClient_id() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public long getBalance() {
		return balance;
	}
	
	public void setBalance(long balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Bill [number=" + number + ", clientId=" + clientId + ", dateCreation=" + dateCreation + ", balance="
				+ balance + ", active=" + active + "]";
	}

}

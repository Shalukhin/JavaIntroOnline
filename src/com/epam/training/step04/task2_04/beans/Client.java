package com.epam.training.step04.task2_04.beans;

import java.util.Arrays;


public class Client {
	
	private String id;
	
	private Bill[] bills = new Bill[0];	
	
	public Client(String id) {
		super();
		this.id = id;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Bill[] getBills() {
		return bills;
	}

	public void setBills(Bill[] bills) {
		this.bills = bills;
	}
	
	public void setBills(Bill bill, int index) {
		if(index >= bills.length) {
			bills = Arrays.copyOf(bills, bills.length + 1);
			bills[bills.length - 1] = bill;
			return;
		}
		bills[index] = bill;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", bills=" + Arrays.toString(bills) + "]";
	}		
}

package com.epam.training.step05.task2.logic;

import java.util.Arrays;

import com.epam.training.step05.task2.beans.Payment;

public class PaymentLogic {
	
	private Payment payment;

	public PaymentLogic(Payment payment) {
		super();
		this.payment = payment;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public void addProduct(String name, long price) {
		Payment.Product temp = payment.new Product(name, price);
		payment.setProducts(temp, payment.getProducts().length);
		
		refreshpriceTotal();
	}
	
	public void deleteProduct(String name) {
		Payment.Product[] temp = payment.getProducts();
		boolean flagDelete = false;
		for (int i = 0; i < temp.length - 1; i++) {
			if (temp[i].getName() == name) {
				flagDelete = true;
			}
			if (flagDelete) {
				temp[i] = temp[i + 1];
			}
		}
		if (temp[temp.length - 1].getName() == name) {
			flagDelete = true;
		}
		if(flagDelete) {
			temp = Arrays.copyOf(temp, temp.length - 1);
		}
		payment.setProducts(temp);
		
		refreshpriceTotal();
	}
	
	private void refreshpriceTotal() {
		long temp = 0;
		for (Payment.Product product : payment.getProducts()) {
			temp = temp + product.getPrice();
		}
		payment.setPriceTotal(temp);
	}	

}

package com.epam.training.step05.task2.view;

import com.epam.training.step05.task2.beans.Payment;

public class Viewer {
	
	public static void printPaymentToConsole(Payment payment) {
		System.out.println("     Чек id = " + payment.getId());
		System.out.println("------------------------");
		for (Payment.Product product : payment.getProducts()) {
			System.out.printf("%s\t\t%d руб.\n", product.getName(), product.getPrice());
		}
		System.out.println("------------------------");
		System.out.printf("Итого:\t\t%d руб.\n", payment.getPriceTotal());
		System.out.println("------------------------");
	}

}

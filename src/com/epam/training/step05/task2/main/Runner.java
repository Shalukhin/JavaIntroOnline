package step05.task2.main;

import step05.task2.beans.Payment;
import step05.task2.logic.PaymentLogic;
import step05.task2.view.Viewer;

public class Runner {

	public static void main(String[] args) {
		
		Payment payment = new Payment("999");
		
		PaymentLogic paymentLogic = new PaymentLogic(payment);
		
		paymentLogic.addProduct("хлеб", 2);
		paymentLogic.addProduct("масло", 3);
		paymentLogic.addProduct("икра", 20);
		
		Viewer.printPaymentToConsole(payment);		
		
		paymentLogic.deleteProduct("икра"); //слишком дорого((
		
		System.out.println();
		
		Viewer.printPaymentToConsole(payment);

	}

}

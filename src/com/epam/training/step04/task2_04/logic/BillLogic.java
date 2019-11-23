package com.epam.training.step04.task2_04.logic;

import com.epam.training.step04.task2_04.beans.Bill;
import com.epam.training.step04.task2_04.view.Viewer;

public class BillLogic {	
	
	private Viewer viewer = new Viewer();
	
	public BillLogic() {
		super();
	}
	
	public void increaseBalance(Bill bill, long amount) {
		if (!bill.isActive()) {
			viewer.showMessageInConsole(String.format("Счёт заблокирован!"));			
			return;
		}
		if (amount < 0) {
			viewer.showMessageInConsole(String.format("Введённая сумма отрицательная. Баланс не изменён!"));
			return;
		}
		bill.setBalance(bill.getBalance() + amount);		
		viewer.showMessageInConsole(String.format("Баланс счёта \"%s\" увеличен на %d. Актуальный баланс: %d\n", bill.getNumber(), amount, bill.getBalance()));
		
	}

	public void decreaseBalance(Bill bill, long amount) {
		if (!bill.isActive()) {
			viewer.showMessageInConsole(String.format("Счёт заблокирован!"));			
			return;
		}
		if (amount < 0) {
			viewer.showMessageInConsole(String.format("Введённая сумма отрицательная. Баланс не изменён!"));			
			return;
		}
		bill.setBalance(bill.getBalance() - amount);		
		viewer.showMessageInConsole(String.format("Баланс счёта \"%s\" уменьшен на %d. Актуальный баланс: %d\n", bill.getNumber(), amount, bill.getBalance()));		
	}

	@Override
	public String toString() {
		return "BillLogic [viewer=" + viewer + "]";
	}
}

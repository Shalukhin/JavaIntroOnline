package step04.task2_04.view;

import step04.task2_04.beans.Bill;
import step04.task2_04.beans.Client;

public class Viewer {
	
	public void showInConsolAllClientsBills(Client client) {

		if (client.getBills().length == 0) {			
			System.out.printf("У клиента нет счетов!\n");
			return;
		}		
		System.out.printf("Список всех счетов клиента id = \"%s\":\n", client.getId());
		
		for (Bill bill : client.getBills()) {
			showInConsoleBill(bill);
		}
	}			
	
	@SuppressWarnings("deprecation")
	public void showInConsoleBill(Bill bill) {
		System.out.printf("Номер счёта: %s; баланс: %d; статус: %s, открыт: %s\n", bill.getNumber(), bill.getBalance(),
				(bill.isActive() ? "активен" : "заблокирован"), bill.getDateCreation().toLocaleString());
	}
	
	public void showMessageInConsole(String message) {
		System.out.println(message);
	}
	
	public void showInConsoleBillActive(Bill bill) {
		System.out.printf("Счёт %s!", (bill.isActive() ? "активен" : "заблокирован"));
	}

}

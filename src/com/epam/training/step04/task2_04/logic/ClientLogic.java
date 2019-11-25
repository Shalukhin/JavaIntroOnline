package com.epam.training.step04.task2_04.logic;

import java.util.Arrays;
import java.util.Comparator;
import com.epam.training.step04.task2_04.beans.Bill;
import com.epam.training.step04.task2_04.beans.Client;
import com.epam.training.step04.task2_04.view.Viewer;

public class ClientLogic {

	private Client client;
	private BillLogic billLogic = new BillLogic();
	private Viewer viewer = new Viewer();

	public ClientLogic(Client client) {
		super();
		this.client = client; 
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void openNewBill(String number) {

		for (Bill bill : client.getBills()) {
			if (bill.getNumber().equals(number)) {
				viewer.showMessageInConsole(String.format("Счёт с номером \"%s\" уже существует!\n", number));				
				return;
			}
		}

		Bill billNew = new Bill(number, client.getId(), 0, true);
		client.setBills(billNew, client.getBills().length);
		
		viewer.showMessageInConsole(String.format("Счёт номер \"%s\" открыт!\n", number));		
	}

	public void closeBill(Bill bill) {
		if (bill == null) {
			viewer.showMessageInConsole(String.format("Попытка закрытия счёта - не удачная!"));			
			return;
		}

		if (client.getBills().length == 0) {
			viewer.showMessageInConsole(String.format("У клиента нет счетов!\n"));			
			return;
		}

		String numberBillWhichClose = bill.getNumber();

		Bill[] tempBills = client.getBills();
		boolean flag_del = false;
		for (int i = 0; i < tempBills.length; i++) {
			if (tempBills[i].equals(bill)) {
				flag_del = true;
			}

			if (flag_del && (i < tempBills.length - 1)) {
				tempBills[i] = tempBills[i + 1];
			}
		}

		if (flag_del) {
			tempBills = Arrays.copyOf(tempBills, tempBills.length - 1);
			client.setBills(tempBills);
			viewer.showMessageInConsole(String.format("Счёт номер \"%s\" успешно закрыт!\n", numberBillWhichClose));			
		} else {
			viewer.showMessageInConsole(String.format("Счёт номер \"%s\", который вы пытаетесь закрыть, не найден!\n", numberBillWhichClose));
		}
	}

	public void closeBillByNumber(String number) {

		if (client.getBills().length == 0) {
			viewer.showMessageInConsole(String.format("У клиента нет счетов!\n"));			
			return;
		}
		
		for (Bill bill : client.getBills()) {
			if (bill.getNumber().equals(number)) {
				closeBill(bill);
				return;
			}
		}
		
		viewer.showMessageInConsole(String.format("Счёт номер \"%s\", который вы пытаетесь закрыть, не найден!\n", number));
	}

	public Bill findBillByNumber(String number) {

		if (client.getBills().length == 0) {
			viewer.showMessageInConsole(String.format("У клиента нет счетов!\n"));			
			return null;
		}
		
		for (Bill bill : client.getBills()) {
			if (bill.getNumber().equals(number)) {
				return bill;
			}
		}
		
		viewer.showMessageInConsole(String.format("Счёт с номером \"%s\" не существует!\n", number));		
		return null;

	}

	public void blockBill(Bill bill) {
		if (!bill.isActive()) {
			viewer.showMessageInConsole(String.format("Счёт \"%s\" уже заблокирован!\n", bill.getNumber()));			
			return;
		}
		bill.setActive(false);
		viewer.showMessageInConsole(String.format("Счёт \"%s\" заблокирован!\n", bill.getNumber()));
	}

	public void unblockBill(Bill bill) {
		if (bill.isActive()) {
			viewer.showMessageInConsole(String.format("Счёт \"%s\" уже разблокирован!\n", bill.getNumber()));			
			return;
		}
		bill.setActive(true);
		viewer.showMessageInConsole(String.format("Счёт \"%s\" разблокирован!\n", bill.getNumber()));		
	}

	public void putMoneyIntoBill(long money, Bill bill) {
		if (bill == null) {
			viewer.showMessageInConsole(String.format("Попытка пополнения счёта - не удачая!"));
			return;
		}

		if (!bill.isActive()) {
			viewer.showMessageInConsole(String.format("Счёт номер \"%s\", который вы пытаетесь пополнить - заблокирован!\n", bill.getNumber()));
			return;
		}
		
		billLogic.increaseBalance(bill, money);
	}

	public void takeMoneyFromBill(long money, Bill bill) {
		if (bill == null) {
			viewer.showMessageInConsole(String.format("Попытка снятия денег со счёта - не удачая!"));			
			return;
		}

		if (!bill.isActive()) {
			viewer.showMessageInConsole(String.format("Счёт номер \"%s\", c которого вы пытаетесь снять деньги - заблокирован!\n", bill.getNumber()));
			return;
		}
		
		billLogic.decreaseBalance(bill, money);
	}

	public void transferMoneyFromBill1ToBill2(long money, Bill bill1, Bill bill2) {
		if (bill1 == null || bill2 == null) {
			viewer.showMessageInConsole(String.format("Попытка перевода денег со счёта на счёт - не удачая!"));			
			return;
		}

		if (!bill1.isActive()) {
			viewer.showMessageInConsole(String.format("Счёт номер \"%s\", c которого вы пытаетесь перевести деньги - заблокирован!\n", bill1.getNumber()));			
			return;
		}

		if (!bill2.isActive()) {
			viewer.showMessageInConsole(String.format("Счёт номер \"%s\", на который вы пытаетесь перевести деньги - заблокирован!\n", bill2.getNumber()));
			return;
		}
		viewer.showMessageInConsole(String.format("Осуществяестя перевод денег со счёта номер \"%s\" на счёт номер \"%s\":\n<<\n", bill1.getNumber(), bill2.getNumber()));
		
		billLogic.decreaseBalance(bill1, money);
		billLogic.increaseBalance(bill2, money);
		
		viewer.showMessageInConsole(String.format(">>\nПеревод выполнен успешно!"));
	}

	public void showTotalBalanceAllBills() {
		long totalBalane = 0;
		for (Bill bill : client.getBills()) {
			totalBalane = totalBalane + bill.getBalance();
		}
		viewer.showMessageInConsole(String.format("Итоговый баланс по всем счетам: %d\n", totalBalane));		
	}

	public void showTotalBalanceAllPositivBills() {
		long totalBalancePositiv = 0;
		for (Bill bill : client.getBills()) {
			if (bill.getBalance() > 0) {
				totalBalancePositiv = totalBalancePositiv + bill.getBalance();
			}
		}
		viewer.showMessageInConsole(String.format("Итоговый баланс по всем счетам с положительным остатком: %d\n", totalBalancePositiv));
	}

	public void showTotalBalanceAllNegativeBills() {
		long totalBalanceNegativ = 0;
		for (Bill bill : client.getBills()) {
			if (bill.getBalance() < 0) {
				totalBalanceNegativ = totalBalanceNegativ + bill.getBalance();
			}
		}
		viewer.showMessageInConsole(String.format("Итоговый баланс по всем счетам с отрицательным остатком: %d\n", totalBalanceNegativ));
	}
	
	public void sortBillsByBalance() {

		Comparator<Bill> comparator = new Comparator<Bill>() {
			@Override
			public int compare(Bill bill1, Bill bill2) {
				if (bill1.getBalance() > bill2.getBalance()) {
					return 1;
				} else if (bill1.getBalance() < bill2.getBalance()) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		client.setBills(qSort(client.getBills(), comparator));
		//bills = qSort(bills, comparator);
		viewer.showMessageInConsole(String.format("Счёта отсортированы по возростанию остатка."));
	}

	public void sortBillsByNumber() {

		Comparator<Bill> comparator = new Comparator<Bill>() {
			@Override
			public int compare(Bill bill1, Bill bill2) {

				if (bill1.getNumber().compareTo(bill2.getNumber()) > 0) {
					return 1;
				} else if (bill1.getNumber().compareTo(bill2.getNumber()) < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		
		client.setBills(qSort(client.getBills(), comparator));
		//bills = qSort(bills, comparator);
		viewer.showMessageInConsole(String.format("Счёта отсортированы по возростанию номера."));
	}

	public void sortBillsByDate() {

		Comparator<Bill> comparator = new Comparator<Bill>() {
			@Override
			public int compare(Bill bill1, Bill bill2) {
				return bill1.getDateCreation().compareTo(bill2.getDateCreation());
			}
		};
		
		client.setBills(qSort(client.getBills(), comparator));
		//bills = qSort(bills, comparator);
		viewer.showMessageInConsole(String.format("Счёта отсортированы по возростанию даты открытия."));
	}

	private Bill[] qSort(Bill[] bills, Comparator<Bill> comparator) {

		if (bills.length < 2) {
			return bills;
		}
		Bill[] one = new Bill[0];
		Bill[] two = new Bill[0];

		for (int i = 1; i < bills.length; i++) {
			if (comparator.compare(bills[i], bills[0]) == -1) {
				one = Arrays.copyOf(one, one.length + 1);
				one[one.length - 1] = bills[i];
			} else {
				two = Arrays.copyOf(two, two.length + 1);
				two[two.length - 1] = bills[i];
			}
		}
		return composite(qSort(one, comparator), bills[0], qSort(two, comparator));
	}

	private Bill[] composite(Bill[] one, Bill mid, Bill[] two) {

		int i = 0;
		Bill[] result = new Bill[one.length + two.length + 1];

		for (int j = 0; j < one.length; j++) {
			result[i] = one[j];
			i++;
		}

		result[i] = mid;
		i++;

		for (int j = 0; j < two.length; j++) {
			result[i] = two[j];
			i++;
		}

		return result;
	}

	@Override
	public String toString() {
		return "ClientLogic [client=" + client + "]";
	}

}

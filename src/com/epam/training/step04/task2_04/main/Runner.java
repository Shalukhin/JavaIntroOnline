/* 4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки 
счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по 
всем счетам, имеющим положительный и отрицательный балансы отдельно. */

/* Класс Runner содержит метод main и создан для демонстрации работы приложения. Запустив приложение, пользователь управляет программой 
выбирая тот или иной пункт текстового меню (вводя с клавиатуры нужную цифру пункта меню). Данная фунциональность обеспечена циклом do-while, 
внутри которого находится конструкция switch-case. На каждой итерации цикла пользователь вводит с клавиатура значение переменной command и, 
по этому значению, с помощью конструкции switch-case, запускаются те или иные методы класса Client. Выход из цикла (завершение программы) 
наступает при введении значения command = 0.
	Также в этом классе определены два вспомогательных метода, отвечающих за получение значений вводимых с консоли:
		getIntFromConsol() - получение с консоли чисел типа int
		getStrFromConsol() - получение с консоли строки типа String 
 */

package step04.task2_04.main;

import java.util.Scanner;

import step04.task2_04.beans.Bill;
import step04.task2_04.beans.Client;
import step04.task2_04.logic.ClientLogic;
import step04.task2_04.view.Viewer;

public class Runner {

	public static void main(String[] args) throws InterruptedException {

		Client client = null;
		ClientLogic clientLogic = null;
		Viewer viewer = new Viewer();

		int command;
		
		do {
			if (client != null) {
				System.out.println("\n---------------------------------------\n"
						+ "1)  Создать нового клиента\n2)  Открыть счёт\n3)  Закрыть счёт\n4)  Блокировка/разблокировка счёта\n5)  Положить/снять деньги со счёта\n"
						+ "6)  Перевести деньги со счёта на счёт\n7)  Показать суммарный баланс по ... \n8)  Сортировать счета по ...\n9)  Показать все счета\n"
						+ "0)  Выйти из программы\n" + "---------------------------------------\n");
			} else {
				System.out.println("1) Создать клиента\n0) Выйти из программы");

			}

			command = getIntFromConsol();
			
			if (client == null && (!(command == 1 || command == 0))) {
				continue;
			}

			switch (command) {
			case (1):

				System.out.println("Введите id клиента:");
				String id = getStrFromConsol();
				client = new Client(id);
				clientLogic = new ClientLogic(client);
				System.out.printf("Создан клиент id = %s:\n", client.getId());
				break;

			case (2):

				System.out.println("Введите номер создаваемого счёта:");
				String number_open = getStrFromConsol();
				clientLogic.openNewBill(number_open);				
				break;

			case (3):

				if (client.getBills().length == 0) {
					System.out.println("У клиента нет счетов!\n");
					break;
				}
				System.out.println("Введите номер закрываемого счёта:");
				String numberClose = getStrFromConsol();
				clientLogic.closeBillByNumber(numberClose);
				break;

			case (4):

				if (client.getBills().length == 0) {
					System.out.println("У клиента нет счетов!\n");
					break;
				}

				System.out.println("Введите номер счёта, который вы хотите блокировать/разблокировать :");
				String numberBlockOrUnblock = getStrFromConsol();
				Bill billUnBlock = clientLogic.findBillByNumber(numberBlockOrUnblock);
				if (billUnBlock == null) {
					break;
				}
				System.out.printf(
						"Что вы хотите сделать со счётом номер \"%s\":\n\t   1) Блокировать\n\t   2) Разблокировать\n   other_num) Ничего не делать - веруться в предыдущее меню\n",
						numberBlockOrUnblock);
				int command_4 = getIntFromConsol();
				if (command_4 == 1) {
					clientLogic.blockBill(billUnBlock);
				} else if (command_4 == 2) {
					clientLogic.unblockBill(billUnBlock);
				}
				break;

			case (5):

				if (client.getBills().length == 0) {
					System.out.println("У клиента нет счетов!\n");
					break;
				}

				System.out.println("Введите номер счёта, с которого (на который) вы хотите снять (положить) деньги:");
				String numberPutTake = getStrFromConsol();
				Bill billPutTake = clientLogic.findBillByNumber(numberPutTake);
				if (billPutTake == null) {
					break;
				}

				System.out.printf("Введите сумму, которую вы хотите снять (положить) на счёт номер \"%s\"\n",
						numberPutTake);
				long sumPutTake = (long) getIntFromConsol();

				System.out.printf(
						"Выберете действие:\n\t   1) Снять %1$d со счёта номер \"%2$s\"\n\t   2) Положить %1$d на счёт номер \"%2$s\"\n   other_num) Ничего не делать - веруться в предыдущее меню\n",
						sumPutTake, billPutTake.getNumber());
				int command_5 = getIntFromConsol();
				if (command_5 == 1) {
					clientLogic.takeMoneyFromBill(sumPutTake, billPutTake);
				} else if (command_5 == 2) {
					clientLogic.putMoneyIntoBill(sumPutTake, billPutTake);
				}
				break;

			case (6):

				if (client.getBills().length == 0) {
					System.out.println("У клиента нет счетов!\n");
					break;
				}

				System.out.println("Введите номер счёта, с которого вы хотите перевести деньги:");
				String numberTransfStart = getStrFromConsol();
				Bill billTransfStart = clientLogic.findBillByNumber(numberTransfStart);
				if (billTransfStart == null) {
					break;
				}

				System.out.println("Введите номер счёта, на который вы хотите перевести деньги:");
				String numberTransfEnd = getStrFromConsol();
				Bill billTransfEnd = clientLogic.findBillByNumber(numberTransfEnd);
				if (billTransfEnd == null) {
					break;
				}

				System.out.printf(
						"Введите сумму, которую вы хотите перевести со счёта номер \"%s\" на счёт номер \"%s\"\n",
						numberTransfStart, numberTransfEnd);
				long sumTransf = (long) getIntFromConsol();

				clientLogic.transferMoneyFromBill1ToBill2(sumTransf, billTransfStart, billTransfEnd);
				break;

			case (7):
				
				if (client.getBills().length == 0) {
					System.out.println("У клиента нет счетов!\n");
					break;
				}

				System.out.printf("Показать суммарный баланс:\n\t   1) по всем счетам\n\t   2) по счетам с положительным остатком\n\t   "
						+ "3) по счетам с отрицательным остатком\n   other_num) Ничего не делать - веруться в предыдущее меню\n");
				int command_7 = getIntFromConsol();
				if (command_7 == 1) {
					clientLogic.showTotalBalanceAllBills();
				} else if (command_7 == 2) {
					clientLogic.showTotalBalanceAllPositivBills();
				} else if (command_7 == 3) {
					clientLogic.showTotalBalanceAllNegativeBills();
				}
				break;
				
			case (8):
				
				if (client.getBills().length == 0) {
					System.out.println("У клиента нет счетов!\n");
					break;
				}
				
				System.out.printf("Сортировать счета:\n\t   1) по величине баланса\n\t   2) по номерам\n\t   "
						+ "3) по времени открытия\n   other_num) Ничего не делать - веруться в предыдущее меню\n");
				int command_8 = getIntFromConsol();
				if (command_8 == 1) {
					clientLogic.sortBillsByBalance();
				} else if (command_8 == 2) {
					clientLogic.sortBillsByNumber();
				} else if (command_8 == 3) {
					clientLogic.sortBillsByDate();
				}
				break;
				
			case (9):				
				viewer.showInConsolAllClientsBills(client);
				break;
			}

		} while (command != 0);

	}

	public static int getIntFromConsol() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextInt()) {
			System.out.println("введите число!");
			sc.next();
		}
		return sc.nextInt();
	}

	public static String getStrFromConsol() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
}

/*4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления. 
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по 
номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем. 
Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами 
назначения должны быть упорядочены по времени отправления.*/

package step04.task1_04;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		Train[] trains = new Train[5];

		trains[0] = new Train("Kiev", 296, "22:00");
		trains[1] = new Train("Grodno", 56, "14:30");
		trains[2] = new Train("Kiev", 82, "14:27");
		trains[3] = new Train("Brest", 482, "07:52");
		trains[4] = new Train("Kiev", 14, "05:40");

		System.out.println("Поезда отправляющиеся сегодня:");

		for (Train train : trains) {
			System.out.println(train);
		}

		String command;

		do {
			System.out.println();
			System.out.println("Введите \"1\" чтобы отсортировать поезда по номеру");
			System.out.println("Введите \"2\" чтобы осортировать поезда по пункту назначения");
			System.out.println("Введите \"3\" чтобы получить информацию о поезде по его номеру");
			System.out.println("Введите \"q\" чтобы завершить программу");

			command = getStrFromCons();

			switch (command) {
			case "1" : {
				
				for (Train train : sortByNumber(trains)) {
					System.out.println(train);
				}
				break;
			}
			
			case "2" : {
				
				for (Train train : sortByAim(trains)) {
					System.out.println(train);
				}
				break;
			}
			
			case "3" : {
				
				System.out.println("Введите номер интересующего поезда:");
				int number = getIntFromCons();				
				showInfoTrain(trains, number);
				
				break;
			}
			
			}
			
		} while (!command.equals("q"));		
	}

	public static Train[] sortByNumber(Train[] trains) {

		Train[] sort_trains = Arrays.copyOf(trains, trains.length);

		for (int i = 0; i < sort_trains.length - 1; i++) {
			for (int j = 0; j < sort_trains.length - 1 - i; j++) {
				if (sort_trains[j].compareToByNumber(sort_trains[j + 1]) > 0) {
					Train temp = sort_trains[j];
					sort_trains[j] = sort_trains[j + 1];
					sort_trains[j + 1] = temp;
				}
			}
		}

		return sort_trains;
	}

	public static Train[] sortByAim(Train[] trains) {

		Train[] sort_trains = Arrays.copyOf(trains, trains.length);

		for (int i = 0; i < sort_trains.length - 1; i++) {
			for (int j = 0; j < sort_trains.length - 1 - i; j++) {
				if (sort_trains[j].compareTo(sort_trains[j + 1]) > 0) {
					Train temp = sort_trains[j];
					sort_trains[j] = sort_trains[j + 1];
					sort_trains[j + 1] = temp;
				}
			}
		}

		return sort_trains;
	}

	public static void showInfoTrain(Train[] trains, int number) {
		for (int i = 0; i < trains.length; i++) {
			if (trains[i].number == number) {
				System.out.println(trains[i]);
				return;
			}
		}
		System.out.println("Поезда с таким номером нет");
	}

	public static String getStrFromCons() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static int getIntFromCons() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextInt()) {
			System.out.println("Введите номер:");
			sc.next();
		}
		return Math.abs(sc.nextInt());
	}
}

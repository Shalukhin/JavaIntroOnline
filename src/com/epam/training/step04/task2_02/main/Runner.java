/*2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться, 
менять колесо, вывести на консоль марку автомобиля.*/

package com.epam.training.step04.task2_02.main;

import com.epam.training.step04.task2_02.beans.Car;
import com.epam.training.step04.task2_02.logic.CarLogic;
import com.epam.training.step04.task2_02.utils.ConsoleScanner;

public class Runner {

	public static void main(String[] args) throws InterruptedException {

		Car car = null;
		CarLogic carLogic = new CarLogic(car);
		ConsoleScanner consoleScanner = new ConsoleScanner();		
		
		int command;
		do {
			if (car != null) {
				System.out.println("\n---------------------------------------\n"
						+ "1)  Создать новый автомобиль\n2)  Завести двигатель\n3)  Заглушить двигатель\n4)  Заправить топливом\n5)  Поехать на заданное расстояие \n"
						+ "6)  Поменять колесо на запаску\n7)  Заменить колесо на новое \n8)  Показать информацию по колёсам \n9)  Показать информацию по двигателю\n"
						+ "10) Показать информацию по топливому баку \n11) Показать марку автомобиля \n12) Показать всю информацию по автомобилю\n0)  Выйти из программы\n"
						+ "---------------------------------------\n");
			} else {
				System.out.println("1) Создать автомобиль\n0) Выйти из программы");				
			}
			
			command = consoleScanner.getIntFromConsol();
			
			if (car == null && (!(command == 1 || command == 0))) {
				continue;
			}
			
			switch (command) {
			case (1):
				System.out.println("Введите марку автомобиля:");
				String model = consoleScanner.getStrFromConsol();
				car = new Car(model);
				carLogic.setCar(car);
				break;
			case (2):
				carLogic.startEngine();
				break;
			case (3):
				carLogic.stopEngine();
				break;
			case (4):
				System.out.println("Введите объём топлива:");
				double volumeFuel = consoleScanner.getIntFromConsol();
				carLogic.addFuel(volumeFuel);
				break;
			case (5):
				System.out.println("Введите расстояние переезда:");
				int distance = consoleScanner.getIntFromConsol();
				carLogic.drive(distance);
				break;
			case (6):
				System.out.println("Выберите заменяемое колесо:\n\t1) - переднее левое\n\t2) - переднее правое\n\t3) - заднее левое\n\t4) - заднее правое\n\tother num) - не менять колесо");
				int commandWheelId = consoleScanner.getIntFromConsol();	
				carLogic.replaceWheelToSpare(commandWheelId);					
				break;
			case (7):
				System.out.println("Выберите заменяемое колесо:\n\t1) - переднее левое\n\t2) - переднее правое\n\t3) - заднее левое\n\t4) - заднее правое\n\t5) - запасное\n\tother key) - не менять колесо");
				int commandWheel = consoleScanner.getIntFromConsol();
				carLogic.replaceWheel(commandWheel);				
				break;
			case (8):
				System.out.println(carLogic.infoAboutWheels());				
				break;
			case (9):
				System.out.println(carLogic.InfoAboutEngine());				
				break;
			case (10):
				System.out.println(carLogic.InfoAboutTank());				
				break;
			case (11):
				System.out.println(car.getModel());				
				break;
			case (12):
				System.out.println(carLogic.info());				
				break;
			case (0):
				System.out.println("Программа завершина");
			}		
			
		} while (command != 0);
	}	
}

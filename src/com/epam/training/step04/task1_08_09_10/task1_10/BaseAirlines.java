/*10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы 
и метод  toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и 
методами. Задать критерии выбора данных и вывести эти данные на консоль.
Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.  
Найти и вывести:  
a) список рейсов для заданного пункта назначения;  
b) список рейсов для заданного дня недели;  
c) список рейсов для заданного дня недели, время вылета для которых больше заданного. */

package com.epam.training.step04.task1_08_09_10.task1_10;

import java.time.LocalTime;
import com.epam.training.step04.task1_08_09_10.AgregationArray;

public class BaseAirlines extends AgregationArray<Airline> {

	public BaseAirlines() {
		super();
		base = new Airline[0];
	}

	public BaseAirlines(Airline[] base) {
		super(base);
	}

	@Override
	public Airline getByID(int id) {
		Airline airline = getTypeByID(id);
		return new Airline(airline.getId(), airline.getAim(), airline.getNumber(), airline.getType(), airline.getTime(), airline.getDay());
	}
	
	public void showAirlinesWithAim(String aim) {
		if (base.length == 0) {
			System.out.println("База пуста!");
			return;
		}
		System.out.printf("Список всех рйсов, пункт назначения которых - %s:\n{\n", aim);
		for (Airline airline : base) {
			if (airline.getAim().equals(aim)) {
				System.out.println(airline);
			}
		}
		System.out.println("}\n");		
	}
	
	public void showAirlinesInDay (String day) {
		if (base.length == 0) {
			System.out.println("База пуста!");
			return;
		}
		System.out.printf("Список всех рйсов в %s:\n{\n", day);
		for (Airline airline : base) {
			if (airline.getDay().equals(day)) {
				System.out.println(airline);
			}
		}
		System.out.println("}\n");
	}
	
	public void showAirlinesInDayAfterTime(String day, LocalTime time) {
		if (base.length == 0) {
			System.out.println("База пуста!");
			return;
		}
		System.out.printf("Список всех рйсов в %s после %s:\n{\n", day, time.toString());
		for (Airline airline : base) {
			if (airline.getDay().equals(day) && airline.getTime().isAfter(time)) {
				System.out.println(airline);
			}
		}
		System.out.println("}\n");
	}
	
}

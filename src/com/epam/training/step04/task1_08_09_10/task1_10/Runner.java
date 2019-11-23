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

public class Runner {

	public static void main(String[] args) {
		
		BaseAirlines base = new BaseAirlines();
		
		base.add(new Airline(1, "Лондон", 445, "Пассажирный", LocalTime.parse("17:00"), "Вторник"));
		base.add(new Airline(2, "Киев", 52, "Пассажирный", LocalTime.parse("22:00"), "Вторник"));
		base.add(new Airline(3, "Лондон", 307, "Пассажирный", LocalTime.parse("09:00"), "Пятница"));
		
		base.showAllObjects();
		
		base.showAirlinesWithAim("Лондон");
		
		base.showAirlinesInDay("Вторник");
		
		base.showAirlinesInDayAfterTime("Вторник", LocalTime.parse("21:00"));

	}

}

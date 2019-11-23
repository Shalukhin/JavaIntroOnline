/*10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы 
и метод  toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и 
методами. Задать критерии выбора данных и вывести эти данные на консоль.
Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.  
Найти и вывести:  
a) список рейсов для заданного пункта назначения;  
b) список рейсов для заданного дня недели;  
c) список рейсов для заданного дня недели, время вылета для которых больше заданного. */

package step04.task1_08_09_10.task1_10;

import java.time.LocalTime;

import step04.task1_08_09_10.Entity;

public class Airline extends Entity {
	
	private String aim;
	private int number;
	private String type;
	private LocalTime time;
	private String day;
	
	public Airline() {
		super();		
	}

	public Airline(int id, String aim, int number, String type, LocalTime time, String day) {
		super();
		setId(id);
		this.aim = aim;
		this.number = number;
		this.type = type;
		this.time = time;
		this.day = day;
	}

	public String getAim() {
		return aim;
	}

	public void setAim(String aim) {
		this.aim = aim;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Рейс id = %d:\n\tПункт назначения :  %s\n\tНомер рейса      :  %d\n\tТип мамолёта     :  %s\n\t"
				+ "Время вылета     :  %s\n\tДень недели      :  %s\n",
				getId(), aim, number, type, time.toString(), day);
	}
	
}

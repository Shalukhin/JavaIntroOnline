/*8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы 
и метод  toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами 
и методами. Задать критерии выбора данных и вывести эти данные на консоль.
Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.  
Найти и вывести:  
a) список покупателей в алфавитном порядке;  
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале */

package com.epam.training.step04.task1_08_09_10.task1_08;

public class Runner {

	public static void main(String[] args) {
		
		BaseCustomers base = new BaseCustomers();
		
		base.add(new Customer(5, "Сидоров", "Павел", "Александрович", "Немига 2", 1, 100500));
		base.add(new Customer(25, "Петров", "Пётр", "Петрович", "Матусевича 45", 5, 999));
		base.add(new Customer(17, "Иванов", "Иван", "Иванович", "Победителей 22", 20, 123456789));		
		
		base.showAllObjects();
		
		base.showSortAllCustomers();
		
		Customer customer = base.getByID(25);
		customer.setId(33);
		customer.setSurname("Романов");
		
		base.updateByID(26, customer);
		base.updateByID(25, customer);
		
		base.showAllObjects();
		
		base.showCustomersWithCardRange(0, 10);
		
		base.deleteObjByID(5);
		
		base.showAllObjects();
		
		if (!base.isBaseEmpty()) {
			base.clearBase();
		}
		
		base.showAllObjects();
	}
		
	

}

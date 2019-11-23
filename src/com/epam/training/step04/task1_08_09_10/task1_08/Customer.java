/*8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы 
и метод  toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами 
и методами. Задать критерии выбора данных и вывести эти данные на консоль.
Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.  
Найти и вывести:  
a) список покупателей в алфавитном порядке;  
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале */

package com.epam.training.step04.task1_08_09_10.task1_08;

import com.epam.training.step04.task1_08_09_10.Entity;

public class Customer extends Entity {
	
	private String surname;
	private String name;
	private String fathers_name;
	private String adress;
	private long number_card;
	private long number_account;
	
	public Customer() {
		super();		
	}

	public Customer(int id, String surname, String name, String fathers_name, String adress, long number_card,
			long number_account) {
		super();
		setId(id);
		this.surname = surname;
		this.name = name;
		this.fathers_name = fathers_name;
		this.adress = adress;
		this.number_card = number_card;
		this.number_account = number_account;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathers_name() {
		return fathers_name;
	}

	public void setFathers_name(String fathers_name) {
		this.fathers_name = fathers_name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public long getNumber_card() {
		return number_card;
	}

	public void setNumber_card(long number_card) {
		this.number_card = number_card;
	}

	public long getNumber_account() {
		return number_account;
	}

	public void setNumber_account(long number_account) {
		this.number_account = number_account;
	}
	
	@Override
	public String toString() {
		
		return String.format("Покупатель id = %d\n\tФамилия      :  %s\n\tИмя          :  %s\n\tОтчество     :  %s\n\t"
				+ "Адрес        :  %s\n\tНомер карты  :  %016d\n\t"
				+ "Номер счёта  :  %013d\n", getId(), surname, name, fathers_name, adress, number_card, number_account);
	}	

}

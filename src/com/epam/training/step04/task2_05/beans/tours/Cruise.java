package com.epam.training.step04.task2_05.beans.tours;

import java.util.Arrays;
import java.util.Formatter;

public class Cruise extends Tour {
	
	private String[] all_countries = {"маршрут не задан"};

	public Cruise() {
		super();		
	}

	public Cruise(String id, int days, String transportation, boolean food, int price) {
		super(id, days, transportation, food, price);
		type = this.getClass().getSimpleName();
	}

	public String[] getAll_countries() {		
		return all_countries;
	}

	public void setAll_countries(String[] all_countries) {
		this.all_countries = all_countries;
	}
	
	public void setAll_countriesIndex(String country, int index) {
		if (index >= all_countries.length ) {
			all_countries = Arrays.copyOf(all_countries, all_countries.length + 1);
			all_countries[all_countries.length - 1] = country;
			return;
		}
		
		all_countries[index] = country;
	}
	
	public String receiveSpecificInfo() {
		@SuppressWarnings("resource")
		Formatter ft = new Formatter();
		ft.format("Маршрут круиза:  ");
		for (int i = 0; i < all_countries.length; i++) {
			ft.format("%d) %s  ", (i + 1), all_countries[i]);
		}		
		return ft.toString();
	}

	@Override
	public String toString() {
		return "Cruise [all_countries=" + Arrays.toString(all_countries) + "]";
	}	
}

package com.epam.training.step04.task2_05.beans.tours;

public class Shopping extends Tour {
	
	private String city = "город не задан";
	private String shop = "магазин не задан";
	
	public Shopping() {
		super();
	}
	
	public Shopping(String id, int days, String transportation, boolean food, int price) {
		super(id, days, transportation, food, price);
		type = this.getClass().getSimpleName();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}
	
	public String receiveSpecificInfo() {		
		return String.format("Шоптур в городе - \"%s\", в магазине - \"%s\"", city, shop);
	}

	@Override
	public String toString() {
		return "Shopping [city=" + city + ", shop=" + shop + "]";
	}
}

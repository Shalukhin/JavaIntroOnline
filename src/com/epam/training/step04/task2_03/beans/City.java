package com.epam.training.step04.task2_03.beans;

import java.util.Formatter;

public class City extends Unit{
	
	private int yearFounded;
	
	public City(String name, int yearFounded, String nameParentUnit, long population) {
		super(name, nameParentUnit, population, 0);
		this.yearFounded = yearFounded;		
	}
	
	public int getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}

	@Override
	protected String stuctureOfUnit() {		
		@SuppressWarnings("resource")
		Formatter fm = new Formatter();
		fm.format("%s City\n", this.name);		
		return fm.toString();		
	}

	@Override
	public String toString() {
		return "City [yearFounded=" + yearFounded + ", nameParentUnit=" + nameParentUnit + ", name=" + name
				+ ", population=" + population + ", area=" + area + "]";
	}
}

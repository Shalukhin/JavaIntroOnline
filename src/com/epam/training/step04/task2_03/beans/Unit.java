/*
 ������ ����������� ����� ��������� ����� �������� � ������ �������� "��������������� �������" ��� "unit". � "��������������� ��������" ��������� ��������� ������: 
 State, Region, District, City - ��� ��� ������� �������� "��������������� �������". �������� "Unit" �������� ��������� ����: �������� (���� "name"), ������������ ��������� (���� "population"), 
 ������� (���� "area"), �������� ��������������� ������� ������� �������� � ���� ������ ��������������� ������� (���� "name_parent_unit"). 
 */

package com.epam.training.step04.task2_03.beans;

public abstract class Unit {
	
	protected String nameParentUnit;
	
	protected String name;
	
	protected long population;
	
	protected double area;
	
	public Unit() {
		super();		
	}
	
	public Unit(String name, String nameParentUnit, long population, double area) {
		super();
		this.name = name;
		this.nameParentUnit = nameParentUnit;
		this.population = population;
		this.area = area;
	}
		
	public String getNameParentUnit() {
		return nameParentUnit;
	}
	public void setNameParentUnit(String nameParentUnit) {
		this.nameParentUnit = nameParentUnit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}	
	
	public double getArea() {
		return area;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	
	protected abstract String stuctureOfUnit();	

	@Override
	public String toString() {
		return "Unit [nameParentUnit=" + nameParentUnit + ", name=" + name + ", population=" + population + ", area="
				+ area + "]";
	}

}

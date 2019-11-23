/*
 Данный абстрактный класс описывает общие свойства и методы сущности "территориальная единица" или "unit". К "территориальным единицам" относятся следующие классы: 
 State, Region, District, City - все они потомки сущности "территориальная единица". Сущность "Unit" включает следующие поля: название (поле "name"), численностью населения (поле "population"), 
 площадь (поле "area"), название территориальной единицы которая включает в себя данную территориальную единицу (поле "name_parent_unit"). 
 */

package step04.task2_03.beans;

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

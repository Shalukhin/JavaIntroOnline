package step04.task2_03.beans;

import java.util.Arrays;

public class District extends CompositeUnit<City>{
	
	
	public District(String name, String nameParentUnit, long population, double area) {
		super(name, nameParentUnit, population, area);		
		arrayUnits = new City[0];		
	}

	@Override
	public String toString() {
		return "District [arrayUnits=" + Arrays.toString(arrayUnits) + ", center=" + center + ", nameParentUnit="
				+ nameParentUnit + ", name=" + name + ", population=" + population + ", area=" + area + "]";
	}
}

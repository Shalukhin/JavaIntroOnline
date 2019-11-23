package step04.task2_03.beans;

import java.util.Arrays;

public class Region extends CompositeUnit<District> {

	public Region(String name, String nameParentUnit, long population) {
		super(name, nameParentUnit, population, 0);		
		arrayUnits = new District[0];
	}

	@Override
	public String toString() {
		return "Region [arrayUnits=" + Arrays.toString(arrayUnits) + ", center=" + center + ", nameParentUnit="
				+ nameParentUnit + ", name=" + name + ", population=" + population + ", area=" + area + "]";
	}	
}

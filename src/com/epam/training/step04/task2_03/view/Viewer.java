package step04.task2_03.view;

import step04.task2_03.beans.Region;
import step04.task2_03.beans.State;
import step04.task2_03.beans.Unit;

public class Viewer {
	
	public void showMessageInConsole(String message) {
		System.out.println(message);
	}
	
	public void showCapitalInConsole(State state) {
		if (state.getCenter() != null) {
			System.out.printf("The capital of %s is %s\n", state.getName(), state.getCenter().getName());
		} else {
			System.out.printf("The capital of %s is not defined!\n", state.getName());
		}		
	}
	
	public void showRegionCentersInConsole(State state) {
		System.out.printf("The list of regional centers %s %s:\n", state.getName(), state.getClass().getSimpleName());
		
		for (Region region : state.getArrayUnits()) {
			System.out.printf("   %s city\n", region.getCenter().getName());
		}		
	}
	
	public void showPopulationInConsole(Unit unit) {
		System.out.printf("The population of %s %s is %d\n", unit.getName(), unit.getClass().getSimpleName(), unit.getPopulation());
	}
	
	
	public void showAreaInConsole(Unit unit) {
		System.out.printf("The area of %s %s is %.3f km2\n", unit.getName(), unit.getClass().getSimpleName(), unit.getArea());
	}
}

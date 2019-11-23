package com.epam.training.step04.task2_03.logic;

import com.epam.training.step04.task2_03.beans.City;
import com.epam.training.step04.task2_03.beans.Region;
import com.epam.training.step04.task2_03.beans.State;
import com.epam.training.step04.task2_03.view.Viewer;

public class StateLogic extends CompositeUnitLogic<Region> {
	
	Viewer viewer = new Viewer();	

	public StateLogic(State state) {
		super(state);		
	}

	public StateLogic() {
		super();
	}
	
	public void setState(State state) {
		super.setCompositeUnit(state);
	}
	
	public void setCapital(City city) {
		compositeUnit.setCenter(city);
		viewer.showMessageInConsole(String.format("%s city has already been setup as capital of %s state", city.getName(), compositeUnit.getName()));
	}
	
	public void calculateArea() {         
		super.calculateArea();
		
		long populationNew = 0;
		for (Region region : compositeUnit.getArrayUnits()) {
			populationNew = populationNew + region.getPopulation();
		}		
		compositeUnit.setPopulation(populationNew);
	}

	@Override
	public String toString() {
		return "StateLogic [compositeUnit=" + compositeUnit + "]";
	}	
}

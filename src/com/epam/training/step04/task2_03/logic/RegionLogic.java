package com.epam.training.step04.task2_03.logic;

import com.epam.training.step04.task2_03.beans.District;
import com.epam.training.step04.task2_03.beans.Region;

public class RegionLogic extends CompositeUnitLogic<District>{

	public RegionLogic(Region region) {
		super(region);
	}

	public RegionLogic() {
		super();
	}
	
	public void setRegion(Region region) {
		super.setCompositeUnit(region);
	}

	@Override
	public String toString() {
		return "RegionLogic [compositeUnit=" + compositeUnit + "]";
	}	
}

package step04.task2_03.logic;

import step04.task2_03.beans.City;
import step04.task2_03.beans.District;

public class DistrictLogic extends CompositeUnitLogic<City>{

	public DistrictLogic(District district) {
		super(district);
	}

	public DistrictLogic() {
		super();
	}
	
	public void setDistrict(District district) {
		super.setCompositeUnit(district);
	}
	
	public void calculateArea() {        
		 //площадь не зависит от входящих территориальных едииц
	}

	@Override
	public String toString() {
		return "DistrictLogic [compositeUnit=" + compositeUnit + "]";
	}
	
}

package step04.task2_02.logic;

import step04.task2_02.beans.Wheel;

public class WheelLogic {
	
	public WheelLogic() {
		super();
	}

	public void resourceDecrease (Wheel wheel, double distance) {
		double resource = wheel.getResource() - distance;
		if (resource < 0) {
			resource = 0;
		}
		wheel.setResource(resource);
	}
}

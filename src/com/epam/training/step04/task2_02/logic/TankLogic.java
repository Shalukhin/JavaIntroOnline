package step04.task2_02.logic;

import step04.task2_02.beans.Tank;

public class TankLogic {
	
	public TankLogic() {
		super();
	}

	public void refuel(Tank tank, double volumeFuel) {

		if ((tank.getVolumeFuel() + volumeFuel) > tank.getVolume()) {
			System.out.printf(
					"Вы пытаетесь залить больше топлива, чем объём бака! Вы залили %.2f л. топлива. Бак полный - %.2f л.\n",
					(tank.getVolume() - tank.getVolumeFuel()), tank.getVolume());
			
			tank.setVolumeFuel(tank.getVolume());			
			return;
		}

		System.out.printf("Вы залили %.2f л. топлива. Топлива в баке - %.2f л.\n", volumeFuel,
				(tank.getVolumeFuel() + volumeFuel));
		tank.setVolumeFuel(tank.getVolumeFuel() + volumeFuel);
	}

	public void fuelDecrease(Tank tank, double distance, double fuelConsumption) {
		
		double volumeFuel = tank.getVolumeFuel() - fuelConsumption / 100 * distance;
		if (volumeFuel < 0) {
			volumeFuel = 0;
		}
		tank.setVolumeFuel(volumeFuel);
	}
}

package step04.task2_02.logic;

import step04.task2_02.beans.Engine;

public class EngineLogic {
	
	public EngineLogic() {
		super();
	}

	public void start(Engine engine) {
		if (engine.getResource() < 1) {
			System.out.println("Двигатель выработал свой ресурс! Замените двигатель!");
			return;
		}
		
		if (!engine.isStarted()) {
			engine.setStarted(true);
			System.out.println("Двигатель заведён");
		} else {
			System.out.println("Двигатель уже заведён!");
		}		
	}
	
	
	public void stop(Engine engine) {
		if (engine.isStarted()) {
			engine.setStarted(false);
			System.out.println("Двигатель остановлен");
		} else {
			System.out.println("Двигатель не заведён!");
		}	
	}
	
	public void resourceDecrease (Engine engine, double distance) {
		double resourceNew = engine.getResource() - distance;
		engine.setResource(resourceNew);
	}

}

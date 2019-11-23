package com.epam.training.step04.task2_02.beans;

public class Engine {
	
	
	private double fuelConsumption;
	private double resource;
	private boolean isStarted;
	
	public Engine() {
		super();		
		fuelConsumption = 8.5;
		resource = 3000;
		isStarted = false;		
	}	
	
	public Engine(double fuelConsumption, double resource) {
		super();
		this.fuelConsumption = fuelConsumption;
		this.resource = resource;
		isStarted = false;
	}
	
	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public double getResource() {
		return resource;
	}

	public void setResource(double resource) {
		this.resource = resource;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

	public String info() {
		return String.format("Расход топлива: %.2f литров на 100 км\nОставшейся ресурс: %.2f км\nСостояние: %s\n", fuelConsumption, resource, (isStarted ? "Работет" : "Остановлен"));
	}

	@Override
	public String toString() {
		return "Engine [fuelConsumption=" + fuelConsumption + ", resource=" + resource + ", isStarted=" + isStarted
				+ "]";
	}
}

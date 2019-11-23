package step04.task2_02.beans;

public class Tank {
	
	private double volume;
	private double volumeFuel;
	
	
	public Tank() {
		super();
		volume = 50;
		volumeFuel = 0;
	}	

	public Tank(double volume, double volumeFuel) {
		super();
		this.volume = volume;
		this.volumeFuel = volumeFuel;
	}	
	
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getVolumeFuel() {
		return volumeFuel;
	}

	public void setVolumeFuel(double volumeFuel) {
		this.volumeFuel = volumeFuel;
	}
	
	public String info() {
		return String.format("Топливо - %.2f / %.2f литров\n", volumeFuel, volume);
	}

	@Override
	public String toString() {
		return "Tank [volume=" + volume + ", volumeFuel=" + volumeFuel + "]";
	}	
}

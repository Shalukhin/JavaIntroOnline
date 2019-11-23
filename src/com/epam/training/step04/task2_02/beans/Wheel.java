package step04.task2_02.beans;

public class Wheel {
	
	private String brand;
	private int radius;	
	private double resource;
	
	public Wheel() {
		super();
		brand = "belshina";
		radius = 15;
		resource = Math.random()*100 + 200;
	}	

	public Wheel(String brand, int radius, double resource) {
		super();
		this.brand = brand;
		this.radius = radius;		
		this.resource = resource;
	}	
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double getResource() {
		return resource;
	}

	public void setResource(double resource) {
		this.resource = resource;
	}
	
	public String info() {
		return String.format("Производитель: %s\nРадиус: %d\nОставшейся ресурс: %.2f км", brand, radius, resource);
	}

	@Override
	public String toString() {
		return "Wheel [brand=" + brand + ", radius=" + radius + ", resource=" + resource + "]";
	}
}

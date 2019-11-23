package com.epam.training.step05.task5.variant_a.beans;

public class Cover {
	
	String color;

	public Cover() {
		super();
		color = "white";
	}

	public Cover(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cover [color=" + color + "]";
	}

	
		
}

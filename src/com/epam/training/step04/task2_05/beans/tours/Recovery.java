package com.epam.training.step04.task2_05.beans.tours;

public class Recovery extends Tour {
	
	private String illness = "болезнь не задана";

	public Recovery() {
		super();
	}

	public Recovery(String id, int days, String transportation, boolean food, int price) {
		super(id, days, transportation, food, price);
		type = this.getClass().getSimpleName();
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}
	
	public String receiveSpecificInfo() {		
		return String.format("Данный тур рекомендован при заболевании \"%s\"", illness);
	}

	@Override
	public String toString() {
		return "Recovery [illness=" + illness + "]";
	}
	
	
}

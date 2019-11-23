package com.epam.training.step05.task5.variant_a.logic;

public class Validator {
	
private String[] permittedNamesOfFlowers = {"роза", "лилия", "тюльпан", "хризантема"};
	
	public boolean validateTypeOfSweet(String name) {
		for (int i = 0; i < permittedNamesOfFlowers.length; i++) {
			if (permittedNamesOfFlowers[i].equals(name)) {
				return true;
			}
		}
		return false;
	}

}

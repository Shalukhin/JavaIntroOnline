package step05.task5.variant_b.logic;

public class Validator {
	
	private String[] permittedTypesOfSweets = {"конфета", "шоколад", "леденец"};
	
	public boolean validateTypeOfSweet(String type) {
		for (int i = 0; i < permittedTypesOfSweets.length; i++) {
			if (permittedTypesOfSweets[i].equals(type)) {
				return true;
			}
		}
		return false;
	}

}

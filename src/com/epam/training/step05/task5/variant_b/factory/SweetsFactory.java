package step05.task5.variant_b.factory;

import step05.task5.variant_b.beans.sweets.Candy;
import step05.task5.variant_b.beans.sweets.Chocolate;
import step05.task5.variant_b.beans.sweets.Lollipop;
import step05.task5.variant_b.beans.sweets.Sweet;

public class SweetsFactory {

	public Sweet getSweet(String type) {
		Sweet sweet = null;
		switch (type) {
		case ("конфета"):
			sweet = new Candy();
			break;
		case ("леденец"):
			sweet = new Lollipop();
			break;
		case ("шоколад"):
			sweet = new Chocolate();
			break;
		}
		return sweet;		
	}
	
	public Sweet getSweet(String type, long price) {
		
		Sweet sweet = getSweet(type);
		
		if (sweet == null) {
			return sweet;
		}
		
		sweet.setPrice(price);		
		return sweet;
	}
	
	

}

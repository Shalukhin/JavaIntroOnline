package step05.task5.variant_b.view;

import step05.task5.variant_b.beans.Gift;
import step05.task5.variant_b.beans.sweets.Sweet;

public class Viewer {
	
	public void printToConsolGift(Gift gift) {
		System.out.println("Подарок состоит из:");
		int count = 0;
		for (Sweet sweet : gift.getSweets()) {
			System.out.printf("%2d) %7s\tцена:%d\n", ++count, sweet.getType(), sweet.getPrice());
		}
		System.out.printf("Упаковка: %s\n", (gift.getBox() == null ? "отсутствует" : "цвет " + gift.getBox().getColor()));		
	}
	
	public void showMessageToConsole(String message) {
		System.out.println(message);
	}

}

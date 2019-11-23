package com.epam.training.step05.task5.variant_a.view;

import com.epam.training.step05.task5.variant_a.beans.FlowerComposition;
import com.epam.training.step05.task5.variant_a.beans.flowers.Flower;

public class Viewer {
	
	public void printToConsolFlowerComposition(FlowerComposition flowerComposition) {
		System.out.println("Цветочная композиция:");
		for (Flower flower : flowerComposition.getFlowers()) {
			System.out.printf("цветок: %10s\tцвет: %s\n", flower.getName(), flower.getColor());
		}
		System.out.printf("Упаковка: %s", (flowerComposition.getCover() == null ? "отсутствует" : flowerComposition.getCover().getColor()));
	}
	
	public void showMessageToConsole(String message) {
		System.out.println(message);
	}

}

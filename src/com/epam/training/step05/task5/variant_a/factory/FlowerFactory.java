package com.epam.training.step05.task5.variant_a.factory;

import com.epam.training.step05.task5.variant_a.beans.flowers.Flower;
import com.epam.training.step05.task5.variant_a.beans.flowers.Lily;
import com.epam.training.step05.task5.variant_a.beans.flowers.Rose;
import com.epam.training.step05.task5.variant_a.beans.flowers.Tulip;
import com.epam.training.step05.task5.variant_a.beans.flowers.Сhrysanthemum;

public class FlowerFactory {

	public FlowerFactory() {
		super();
	}

	public Flower getFlower(String name) {
		Flower flower = null;
		switch (name) {
		case ("роза"):
			flower = new Rose();
			break;
		case ("лилия"):
			flower = new Lily();
			break;
		case ("тюльпан"):
			flower = new Tulip();
			break;
		case ("хризантема"):
			flower = new Сhrysanthemum();
			break;
		}
		return flower;
	}
	
	public Flower getFlower(String name, String color) {
		Flower flower = getFlower(name);
		flower.setColor(color);
		return flower;
	}
	
	

}

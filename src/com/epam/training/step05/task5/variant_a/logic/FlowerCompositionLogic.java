package com.epam.training.step05.task5.variant_a.logic;

import java.util.Arrays;

import com.epam.training.step05.task5.variant_a.beans.Cover;
import com.epam.training.step05.task5.variant_a.beans.FlowerComposition;
import com.epam.training.step05.task5.variant_a.beans.flowers.Flower;
import com.epam.training.step05.task5.variant_a.factory.FlowerFactory;
import com.epam.training.step05.task5.variant_a.view.Viewer;

public class FlowerCompositionLogic {
	
	private FlowerComposition flowerComposition;
	private FlowerFactory flowerFactory = new FlowerFactory();
	private Validator validator = new Validator();
	private Viewer viewer = new Viewer();
	

	public FlowerCompositionLogic(FlowerComposition flowerComposition) {
		super();
		this.flowerComposition = flowerComposition;
	}

	public FlowerComposition getFlowerComposition() {
		return flowerComposition;
	}

	public void setFlowerComposition(FlowerComposition flowerComposition) {
		this.flowerComposition = flowerComposition;
	}
	
	public boolean addFlower(String name, String color) {
				
		if (!validator.validateTypeOfSweet(name)) {
			viewer.showMessageToConsole("цветов \"" + name + "\" нет в наличии");
			return false;
		}
		
		Flower flower = flowerFactory.getFlower(name, color);
		
		if (flower == null) {
			return false;
		}
		
		flowerComposition.setFlowers(flower, flowerComposition.getFlowers().length);
		return true;
	}
	
	public boolean addFlowers(int count, String name, String color) {
		for (int i = 0; i < count; i++) {
			if (!addFlower(name, color)) {
				return false;
			}
		}
		return true;
	}
	
	public void deleteFlower(String name, String color) {
		Flower[] flowersTemp = flowerComposition.getFlowers();
		boolean flagDelete = false;
		for (int i = 0; i < flowersTemp.length - 1; i++) {
			if (flowersTemp[i].getName() == name && flowersTemp[i].getColor() == color) {
				flagDelete = true;
			}
			if (flagDelete) {
				flowersTemp[i] = flowersTemp[i + 1];
			}
		}
		
		if (flowersTemp[flowersTemp.length - 1].getName() == name && flowersTemp[flowersTemp.length - 1].getColor() == color) {
			flagDelete = true;
		}
		
		if (flagDelete) {
			flowersTemp = Arrays.copyOf(flowersTemp, flowersTemp.length - 1);
		}
		
		flowerComposition.setFlowers(flowersTemp);
		
	}
	
	public void deleteFlowers(String name, String color) {
		int countFlowersInCompositionBeforeDelete;
		do {
			countFlowersInCompositionBeforeDelete = flowerComposition.getFlowers().length;
			deleteFlower(name, color);
		} while (countFlowersInCompositionBeforeDelete != flowerComposition.getFlowers().length);
	}
	
	public void mixFlowers() {
		Flower[] flowersTemp = flowerComposition.getFlowers();
		for (int i = 0; i < flowersTemp.length; i++) {
			int rndIndex = (int) (Math.random()*flowersTemp.length);
			Flower temp = flowersTemp[i];
			flowersTemp[i] = flowersTemp[rndIndex];
			flowersTemp[rndIndex] = temp;
		}
	}
	
	public void makeCover(String color) {
		if (flowerComposition.getCover() == null) {
			flowerComposition.setCover(new Cover(color));
			return;
		}
		flowerComposition.getCover().setColor(color);
	}
	

}

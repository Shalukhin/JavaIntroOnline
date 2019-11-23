package com.epam.training.step05.task5.variant_a.main;

import com.epam.training.step05.task5.variant_a.beans.FlowerComposition;
import com.epam.training.step05.task5.variant_a.logic.FlowerCompositionLogic;
import com.epam.training.step05.task5.variant_a.view.Viewer;

public class Runner {

	public static void main(String[] args) {
		
		FlowerComposition flowerComposition = new FlowerComposition();
		FlowerCompositionLogic flowerCompositionLogic = new FlowerCompositionLogic(flowerComposition);
		
		flowerCompositionLogic.addFlowers(10, "роза", "красный");
		flowerCompositionLogic.addFlowers(10, "роза", "жёлтый");
		flowerCompositionLogic.addFlowers(10, "роза", "белый");
		flowerCompositionLogic.addFlowers(10, "лилия", "розовый");
		flowerCompositionLogic.addFlower("хризантема", "белый");
		flowerCompositionLogic.addFlower("ромашка", "белый");
		
		flowerCompositionLogic.deleteFlowers("роза", "жёлтый");
		
		flowerCompositionLogic.mixFlowers();
		
		flowerCompositionLogic.makeCover("синий");		
		
		Viewer viewer = new Viewer();
		
		viewer.printToConsolFlowerComposition(flowerComposition);
		

	}

}

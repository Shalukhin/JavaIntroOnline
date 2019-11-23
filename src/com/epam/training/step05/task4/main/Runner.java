package step05.task4.main;

import step05.task4.beans.Cave;
import step05.task4.beans.Dragon;
import step05.task4.logic.CaveLogic;
import step05.task4.logic.DragonLogic;
import step05.task4.view.Viewer;

public class Runner {

	public static void main(String[] args) {
		
		Dragon dragon = new Dragon("Vasia", new Cave(10));
				
		CaveLogic caveLogic = new CaveLogic(dragon.getCave());
		DragonLogic dragonLogic = new DragonLogic(dragon);
				
		caveLogic.generateAllTreasuries();
				
		Viewer viewer = new Viewer();
				
		viewer.printToConsolAllDragonsTreasures(dragon);
		System.out.println();
		
		viewer.printToConsolOneTreasure(dragonLogic.askTreasureByName("treasure8"));
		System.out.println();
		
		System.out.println("Наиболее дорогое сокровище:");
		viewer.printToConsolOneTreasure(dragonLogic.askTreasureMostExpencive());
		System.out.println();
		
		
		Cave.Treasure[] treasures = dragonLogic.askTreasuresBySum(1500);
		System.out.println("Сокровища на сумму 1500:");
		viewer.printToConsolSeveralTreasures(treasures);
		System.out.println("точная цена данных сокровищ: " + dragonLogic.askSumPriceSeveralTreasures(treasures));	

	}

}

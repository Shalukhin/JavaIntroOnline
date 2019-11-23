package step05.task4.view;

import step05.task4.beans.Cave;
import step05.task4.beans.Dragon;

public class Viewer {
	
	public void printToConsolAllDragonsTreasures(Dragon dragon) {
		System.out.printf("Все сокровища дракона %s:\n", dragon.getName());
		for (Cave.Treasure treasure : dragon.getCave().getTreasuries()) {
			System.out.println(treasure.getName() + "\t" + treasure.getPrice());
		}
	}
	
	public void printToConsolSeveralTreasures(Cave.Treasure[] treasures) {
		System.out.println("Перечень сокровищ:");
		for (Cave.Treasure treasure : treasures) {
			System.out.println(treasure.getName() + "\t" + treasure.getPrice());
		}
	}
	
	public void printToConsolOneTreasure(Cave.Treasure treasure) {
		System.out.printf("Сокровище:\n%s\t%d\n", treasure.getName(), treasure.getPrice());		
	}

}

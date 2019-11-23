package step05.task4.logic;

import step05.task4.beans.Cave;

public class CaveLogic {
	
	private Cave cave;

	public CaveLogic(Cave cave) {
		super();
		this.cave = cave;
	}

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}
	
	public void generateAllTreasuries() {
		for (int i = 0; i < cave.getTreasuries().length; i++) {
			Cave.Treasure treasure = cave.new Treasure("treasure" + (i + 1), (int)(Math.random()*1000));
			cave.setTreasuries(treasure, i);
		}
	}

	@Override
	public String toString() {
		return "CaveLogic [cave=" + cave + "]";
	}
	
	

}

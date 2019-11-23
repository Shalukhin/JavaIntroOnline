package com.epam.training.step05.task4.logic;

import java.util.Arrays;

import com.epam.training.step05.task4.beans.Cave;
import com.epam.training.step05.task4.beans.Dragon;

public class DragonLogic {
	
	private Dragon dragon;

	public DragonLogic(Dragon gragon) {
		super();
		this.dragon = gragon;
	}

	public Dragon getGragon() {
		return dragon;
	}

	public void setGragon(Dragon gragon) {
		this.dragon = gragon;
	}
	
	public Cave.Treasure askTreasureByName(String name) {
		for (Cave.Treasure treasure : dragon.getCave().getTreasuries()) {
			if (treasure.getName().equals(name)) {
				return treasure;
			}
		}
		return null;
	}
	
	public Cave.Treasure askTreasureMostExpencive(){
		
		long priceMax = -1;
		int indPriceMax = -1;
		for (int i = 0; i < dragon.getCave().getTreasuries().length; i++) {
			if (dragon.getCave().getTreasuries()[i].getPrice() > priceMax) {
				priceMax = dragon.getCave().getTreasuries()[i].getPrice();
				indPriceMax = i;
			}
		}
		return (indPriceMax == -1 ? null : dragon.getCave().getTreasuries()[indPriceMax]);
	}
	
	public Cave.Treasure[] askTreasuresBySum(long sum){
		Cave.Treasure[] rezult = new Cave.Treasure[0];
		Cave.Treasure[] exist = dragon.getCave().getTreasuries();
		
		while (exist.length > 0) {			
			int rndInd = (int) (Math.random() * exist.length);			
			if (sum - exist[rndInd].getPrice() >= 0) {
				rezult = Arrays.copyOf(rezult, rezult.length + 1);
				rezult[rezult.length - 1] = exist[rndInd];
				sum = sum - exist[rndInd].getPrice();								 
			}
			exist = deleteTreasure(exist, exist[rndInd]);
		}
		return rezult;
	}
	
	private Cave.Treasure[] deleteTreasure(Cave.Treasure[] treasures, Cave.Treasure treasure){
		boolean flagDelete = false;
		for (int i = 0; i < treasures.length - 1; i++) {
			if (treasures[i].getName() == treasure.getName() && treasures[i].getPrice() == treasure.getPrice()) {
				flagDelete = true;				
			}
			if (flagDelete) {
				treasures[i] = treasures[i + 1];				
			}
		}
		if (treasures[treasures.length - 1].getName() == treasure.getName() && treasures[treasures.length - 1].getPrice() == treasure.getPrice()) {
			flagDelete = true;
		}
		if (flagDelete) {
			treasures = Arrays.copyOf(treasures, treasures.length - 1);				
		}	
		return treasures;
	}
	
	public long askSumPriceSeveralTreasures(Cave.Treasure[] treasures) {
		long sumPrice = 0;
		for (int i = 0; i < treasures.length; i++) {
			sumPrice = sumPrice + treasures[i].getPrice();
		}
		return sumPrice;
	}
	

	@Override
	public String toString() {
		return "DragonLogic [dragon=" + dragon + "]";
	}
	
	
	

}

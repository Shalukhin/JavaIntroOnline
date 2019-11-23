package step05.task5.variant_b.logic;

import java.util.Arrays;

import step05.task5.variant_b.beans.Box;
import step05.task5.variant_b.beans.Gift;
import step05.task5.variant_b.beans.sweets.Sweet;
import step05.task5.variant_b.factory.SweetsFactory;
import step05.task5.variant_b.view.Viewer;

public class GiftLogic {
	
	private Gift gift;
	private SweetsFactory sweetsFactory = new SweetsFactory();
	private Validator validator = new Validator();
	private Viewer viewer = new Viewer(); 
	
	
	public GiftLogic(Gift gift) {
		super();
		this.gift = gift;
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}
	
	public boolean addSweet(String type, long price) {
		
		if (!validator.validateTypeOfSweet(type)) {
			viewer.showMessageToConsole("тип сладости \"" + type + "\" не найден!");
			return false;
		}
		
		Sweet sweet = sweetsFactory.getSweet(type, price);
		
		if (sweet == null) {
			return false;
		}
		
		gift.setSweets(sweet, gift.getSweets().length);
		
		return true;
		
	}
	
	public boolean addSweets(int count, String type, long price) {
		
		for (int i = 0; i < count; i++) {
			if (!addSweet(type, price)) {
				return false;
			}			
		}
		return true;
	}
	
	public boolean deleteSweet(String type, long price) {
		int markerLengthBeforeDelete = gift.getSweets().length;
		
		boolean flagDelete = false;
		Sweet[] tempSweets = gift.getSweets();
		for (int i = 0; i < tempSweets.length - 1; i++) {
			if (tempSweets[i].getType().equals(type) && tempSweets[i].getPrice() == price) {
				flagDelete = true;
			}
			
			if (flagDelete) {
				tempSweets[i] = tempSweets[i + 1];
			}
		}
		
		if (tempSweets[tempSweets.length - 1].getType().equals(type) && tempSweets[tempSweets.length - 1].getPrice() == price) {
			flagDelete = true;
		}
		
		if (flagDelete) {
			tempSweets = Arrays.copyOf(tempSweets, tempSweets.length - 1);
		}
		
		gift.setSweets(tempSweets);
		
		if (markerLengthBeforeDelete == gift.getSweets().length) {
			return false;
		} else {
			return true;
		}		
	}
	
	public int deleteSweets(String type, long price) {
		int countDeletedSweets = 0;
		while (deleteSweet(type, price)) {
			countDeletedSweets++;
		}
		return countDeletedSweets;
	}
	
	public long totalPrice() {
		long total = 0;
		for (Sweet sweet : gift.getSweets()) {
			total = total + sweet.getPrice();
		}
		return total;
	}
	
	public void createBox(String color) {
		if (gift.getBox() == null) {
			gift.setBox(new Box(color));
			return;
		}
		gift.getBox().setColor(color);
	}
	
	public void deleteBox() {
		gift.setBox(null);
	}
	
	

	@Override
	public String toString() {
		return "GiftLogic [gift=" + gift + ", sweetsFactory=" + sweetsFactory + "]";
	}
	
	
	

}

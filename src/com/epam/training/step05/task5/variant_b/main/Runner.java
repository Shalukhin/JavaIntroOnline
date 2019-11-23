package com.epam.training.step05.task5.variant_b.main;

import com.epam.training.step05.task5.variant_b.beans.Gift;
import com.epam.training.step05.task5.variant_b.logic.GiftLogic;
import com.epam.training.step05.task5.variant_b.view.Viewer;


public class Runner {
	
	public static void main (String[] args) {
		
		Gift gift = new Gift();
		GiftLogic giftLogic = new GiftLogic(gift);
		Viewer viewer = new Viewer();
		
		giftLogic.addSweet("конфета", 10);
		giftLogic.addSweet("мармелад", 15);
		giftLogic.addSweets(3, "леденец", 3);
		giftLogic.addSweets(2, "шоколад", 8);
		giftLogic.createBox("зелёный");
		
		viewer.printToConsolGift(gift);
		System.out.printf("Цена подарка: %d\n", giftLogic.totalPrice());
		System.out.println();
		
		giftLogic.deleteSweet("леденец", 3);
		giftLogic.createBox("красный в крапинку");
		
		viewer.printToConsolGift(gift);
		System.out.printf("Цена подарка: %d\n", giftLogic.totalPrice());
		System.out.println();
		
		giftLogic.deleteSweets("шоколад", 8);
		giftLogic.deleteBox();
		
		viewer.printToConsolGift(gift);
		System.out.printf("Цена подарка: %d\n", giftLogic.totalPrice());
		System.out.println();
		
		
	}

}

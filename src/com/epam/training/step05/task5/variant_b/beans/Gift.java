package com.epam.training.step05.task5.variant_b.beans;

import java.util.Arrays;

import com.epam.training.step05.task5.variant_b.beans.sweets.Sweet;

public class Gift {
	
	private Sweet[] sweets = new Sweet[0];
	private Box box = null;

	public Gift() {
		super();
	}

	public Gift(Sweet[] sweets, Box box) {
		super();
		this.sweets = sweets;
		this.box = box;
	}

	public Sweet[] getSweets() {
		return sweets;
	}

	public void setSweets(Sweet[] sweets) {
		this.sweets = sweets;
	}
	
	public void setSweets(Sweet sweet, int index) {
		
		if (index >= sweets.length) {
			sweets = Arrays.copyOf(sweets, sweets.length + 1);
			sweets[sweets.length - 1] = sweet;
			return;
		}
		
		sweets[index] = sweet;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

	@Override
	public String toString() {
		return "Gift [sweets=" + Arrays.toString(sweets) + ", box=" + box + "]";
	}
}

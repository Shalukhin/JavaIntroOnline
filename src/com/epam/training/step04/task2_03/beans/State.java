package com.epam.training.step04.task2_03.beans;

import java.util.Arrays;

public class State extends CompositeUnit<Region>{

	public State(String name) {
		super(name, "Planet Earth", 0, 0);
		arrayUnits = new Region[0];
	}

	@Override
	public String toString() {
		return "State [arrayUnits=" + Arrays.toString(arrayUnits) + ", center=" + center + ", nameParentUnit="
				+ nameParentUnit + ", name=" + name + ", population=" + population + ", area=" + area + "]";
	}
}

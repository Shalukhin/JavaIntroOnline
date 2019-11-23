package com.epam.training.step04.task2_03.logic;

import java.util.Arrays;
import java.util.Formatter;

import com.epam.training.step04.task2_03.beans.CompositeUnit;
import com.epam.training.step04.task2_03.beans.Unit;

public abstract class CompositeUnitLogic<T extends Unit> {

	protected CompositeUnit<T> compositeUnit;

	public CompositeUnitLogic() {
		super();
	}

	public CompositeUnitLogic(CompositeUnit<T> compositeUnit) {
		super();
		this.compositeUnit = compositeUnit;
	}

	public CompositeUnit<T> getCompositeUnit() {
		return compositeUnit;
	}

	protected void setCompositeUnit(CompositeUnit<T> compositeUnit) {
		this.compositeUnit = compositeUnit;
	}

	public void addUnit(T unit) {
		T[] units = compositeUnit.getArrayUnits();
		units = Arrays.copyOf(units, units.length + 1);
		units[units.length - 1] = unit;
		compositeUnit.setArrayUnits(units);

		calculateArea();
	}

	public void addArreyUnits(T[] addArrayUnit) {
		for (int i = 0; i < addArrayUnit.length; i++) {
			if (compositeUnit.getName().equals(addArrayUnit[i].getNameParentUnit())) {
				addUnit(addArrayUnit[i]);
			}
		}
	}

	public void delUnit(T unit) {
		if (compositeUnit.getArrayUnits().length == 0) {
			System.out.println("Структура пуста!");
			return;
		}

		T[] tempArrayUnits = compositeUnit.getArrayUnits();
		boolean flag_del = false;

		for (int i = 0; i < tempArrayUnits.length; i++) {
			if (tempArrayUnits[i].equals(unit)) {
				flag_del = true;
			}
			if (flag_del && i != tempArrayUnits.length - 1) {
				tempArrayUnits[i] = tempArrayUnits[i + 1];
			}
		}
		if (flag_del) {
			tempArrayUnits = Arrays.copyOf(tempArrayUnits, tempArrayUnits.length - 1);
			compositeUnit.setArrayUnits(tempArrayUnits);
			System.out.printf("%s удалён!\n", tempArrayUnits[0].getClass().getSimpleName());
		} else {
			System.out.printf("%s не найден!\n", tempArrayUnits[0].getClass().getSimpleName());
		}

		calculateArea();
	}

	public void delUnitByName(String name) {
		if (compositeUnit.getArrayUnits().length == 0) {
			System.out.println("Структура пуста!");
			return;
		}

		for (T unit : compositeUnit.getArrayUnits()) {
			if (unit.getName().equals(name)) {
				delUnit(unit);
				return;
			}
		}
	}

	public void calculateArea() { // перереопределить где надо
		double area = 0;

		for (T unit : compositeUnit.getArrayUnits()) {
			area = area + unit.getArea();
		}

		compositeUnit.setArea(area);
	}

	public String unitConsistOf() {
		
		@SuppressWarnings("resource")
		Formatter fm = new Formatter();
		fm.format("The %s %s includes:\n", compositeUnit.getName(), compositeUnit.getClass().getSimpleName());
		//System.out.printf("The %s %s includes:\n", compositeUnit.getName(), this.getClass().getSimpleName());
		if (compositeUnit.getArrayUnits().length == 0) {
			fm.format("   !пусто!\n");
			//System.out.println("   !пусто!");
		}

		for (T unit : compositeUnit.getArrayUnits()) {
			fm.format("   %s %s\n", unit.getName(), unit.getClass().getSimpleName());
			//System.out.printf("   %s %s\n", unit.getName(), unit.getClass().getSimpleName());
		}
		return fm.toString();
	}
}

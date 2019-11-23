/*
 Данный абстрактный класс описывает общие свойства и методы сущности "составная территориальная единица" или "compositeUnit". К "составным территориальным единицам" относятся 
те территориальные единицы, в состав которых входит (агрегация) массив более мелких территориальных единиц - arrayUnit. Потомки данного класса - 
State, Region, District. Данный класс расширяет класс Unit
 */

package step04.task2_03.beans;

import java.util.Arrays;
import java.util.Formatter;

public abstract class CompositeUnit<T extends Unit> extends Unit {

	protected T[] arrayUnits = null;

	protected City center = null;

	public CompositeUnit() {
		super();
	}

	public CompositeUnit(String name, String parentStructuralUnit, long population, double area) {
		super(name, parentStructuralUnit, population, area);
	}

	public T[] getArrayUnits() {
		return arrayUnits;
	}

	public void setArrayUnits(T[] arrayUnits) {
		this.arrayUnits = arrayUnits;
	}

	public void setArrayUnits(T arrayUnit, int index) {
		if (index >= arrayUnits.length) {
			arrayUnits = Arrays.copyOf(arrayUnits, arrayUnits.length + 1);
			arrayUnits[arrayUnits.length - 1] = arrayUnit;
			return;
		}
		arrayUnits[index] = arrayUnit;
	}

	public City getCenter() {
		return center;
	}

	public void setCenter(City center) {
		this.center = center;
	}

	public String stuctureOfUnit() {

		@SuppressWarnings("resource")
		Formatter fm = new Formatter();
		fm.format("%s %s\n", name, this.getClass().getSimpleName());
		for (int i = 0; i < arrayUnits.length; i++) {
			String[] units = arrayUnits[i].stuctureOfUnit().split("\\n");
			for (int j = 0; j < units.length; j++) {
				fm.format("   %s\n", units[j]);
			}
		}
		return fm.toString();
	}

	@Override
	public String toString() {
		return "CompositeUnit [arrayUnits=" + Arrays.toString(arrayUnits) + ", center=" + center + "]";
	}

}

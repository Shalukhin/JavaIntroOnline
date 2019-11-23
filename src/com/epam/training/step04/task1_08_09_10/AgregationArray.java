package com.epam.training.step04.task1_08_09_10;

import java.util.Arrays;

public abstract class AgregationArray <T extends Entity> {
	
	protected T[] base;

	public AgregationArray() {
		super();		
	}

	public AgregationArray(T[] base) {
		super();
		this.base = Arrays.copyOf(base, base.length);;
	}

	public void add(T obj) {
		base = Arrays.copyOf(base, base.length + 1);
		base[base.length - 1] = obj;
		System.out.printf("Добавлен новый %s!\n", obj.getClass().getSimpleName());
	}
	
	protected T getTypeByID(int id) {
		if (base.length == 0) {
			System.out.println("База пуста!");
			return null;
		}
		for (int i = 0; i < base.length; i++) {
			if (base[i].getId() == id) {
				return base[i];
			}
		}
		System.out.printf("%s не найден!\n", base[0].getClass().getSimpleName());
		return null;
	}
	
	public abstract T getByID(int id);
	
	public void updateByID(int id, T obj) {
		if (base.length == 0) {
			System.out.println("База пуста!");
			return;
		}
		for (int i = 0; i < base.length; i++) {
			if (base[i].getId() == id) {
				base[i] = obj;
				return;
			}
		}
		System.out.printf("%s не найден!\n", obj.getClass().getSimpleName());
	}
	
	public void deleteObj(T obj) {
		if (base.length == 0) {
			System.out.println("База пуста!");
			return;
		}
		boolean flag_del = false;
		for (int i = 0; i < base.length; i++) {
			if (base[i].equals(obj)) {
				flag_del = true;
			}
			if (flag_del && i != base.length - 1) {
				base[i] = base[i + 1];
			}
		}
		if (flag_del) {
			base = Arrays.copyOf(base, base.length - 1);
			System.out.printf("%s удалён!\n", base[0].getClass().getSimpleName());
		} else {
			System.out.printf("%s не найден!\n", base[0].getClass().getSimpleName());
		}
	}
	
	public void deleteObjByID(int id) {
		if (base.length == 0) {
			System.out.println("База пуста!");
			return;
		}

		for (int i = 0; i < base.length; i++) {
			if (base[i].getId() == id) {
				deleteObj(base[i]);
				return;
			}
		}
	}
	
	public void showAllObjects() {
		if (base.length == 0) {
			System.out.println("База пуста!");
			return;
		}

		System.out.printf("Список всех %s:\n{\n", base[0].getClass().getSimpleName());
		for (T obj : base) {
			System.out.println(obj);
		}
		System.out.println("}\n");
	}
	
	public void clearBase() {
		base = Arrays.copyOf(base, 0);
		System.out.println("База отчищена!");
	}
	
	public boolean isBaseEmpty() {
		return base.length == 0;
	}

	
}

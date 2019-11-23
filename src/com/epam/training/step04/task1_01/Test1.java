/*1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих 
переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит 
наибольшее значение из этих двух переменных. */

package com.epam.training.step04.task1_01;

public class Test1 {
	
	public int a = 3;
	
	public int b = 5;
	
	public void print() {
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}	

	public void changeA (int a) {
		
		this.a = a;
	}
	
	public void changeB (int b) {
		
		this.b = b;
	}
	
	public int sum () {
		
		return a + b;
	}
	
	public int max () {
		
		return Math.max(a, b);
	}

	@Override
	public String toString() {
		return "Test1 [a=" + a + ", b=" + b + "]";
	}

}

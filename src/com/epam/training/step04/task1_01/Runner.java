/* 1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих 
переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит 
наибольшее значение из этих двух переменных. */

package com.epam.training.step04.task1_01;

public class Runner {

	public static void main(String[] args) {
		
		Test1 t = new Test1();
		
		t.print();
		
		t.changeA(45);
		t.changeB(29);
		
		t.print();
		
		System.out.println("a + b = " + t.sum());
		
		System.out.println("Максимальное значение: " + t.max());

	}

}

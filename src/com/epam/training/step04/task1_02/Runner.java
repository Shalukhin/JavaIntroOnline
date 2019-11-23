/* 2. Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте 
конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра 
класса.*/

package com.epam.training.step04.task1_02;

public class Runner {

	public static void main(String[] args) {
		
		Test2 t1 = new Test2(10, 20);
		
		Test2 t2 = new Test2();
		
		System.out.println("t1 :\n" + t1.toString());
		System.out.println();
		System.out.println("t2 :\n" + t2.toString());
		
		t2.setA(66);
		t2.setB(99);
		
		System.out.println();
		System.out.println("t2: a = " + t2.getA());
		System.out.println("t2: b = " + t2.getB());
		

	}

}

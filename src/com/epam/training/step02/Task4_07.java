/* 7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9. */

package com.epam.training.step02;

public class Task4_07 {

	public static void main(String[] args) {

		int a = 1;
		int b = 9;
		
		System.out.println("\nСумма факториалов:  " + sumFact(a, b));
	}
	
	
	public static long sumFact (int a, int b) {
		
		long sum = 0;
		
		System.out.println("Число    Факториал");
		
		for (int i = a; i <= b; i++) {
			
			if (i % 2 != 0) {
				
				System.out.printf("%2d       %d \n", i, factorial(i));
				sum = sum + factorial(i);
			}
		}
		return sum;
	}
	
	
	public static long factorial (int a) {
		
		long pr = 1;
		
		for (int i = 1; i <= a; i++) {
			pr = pr * i;
		}
		
		return pr;
	}
}

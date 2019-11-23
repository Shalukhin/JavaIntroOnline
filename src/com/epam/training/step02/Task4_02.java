/* 2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.*/

package com.epam.training.step02;

public class Task4_02 {

	public static void main(String[] args) {
		
		int a = 4;
		int b = 6;
		int c = 8;
		int d = 10;
		
		System.out.printf("a = %d\nb = %d\nc = %d\nd = %d\n\nНОД (a, b, c, d) = %d", a, b, c, d, getNodForFourNum(a, b, c, d));
	}
	
	public static int getNodForFourNum (int a, int b, int c, int d) {
		
		int min = Math.min(Math.min(a, b), Math.min(c, d));
		
		for (int i = min; i > 1; i--) {
			int ost = a % i + b % i + c % i + d % i;
			if (ost == 0) return i; 
		}
		return 1;
	}
}

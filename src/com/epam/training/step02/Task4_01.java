/* 1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух натуральных чисел */

package step02;

import java.util.Scanner;

public class Task4_01 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Введите целое значение: a = ");
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.println("Введите целое значение: a = ");
		}
		int a = sc.nextInt();
		System.out.println("Принято, a = " + a);
		
		System.out.println("Введите целое значение: b = ");
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.println("Введите целое значение: b = ");
		}
		int b = sc.nextInt();
		System.out.println("Принято, b = " + b);
		
		System.out.println();
		System.out.println("НОД (a , b) = " + getNodForTwoNum(a, b));
		System.out.println("НОК (a , b) = " + getNokForTwoNum(a, b));

	}
	
	public static int getNodForTwoNum (int a, int b) {
		int min = a;
		if (b < min) {
			min = b;
		}
		for (int i = min; i > 1; i--) {
			int ost = a % i + b % i;
			if (ost == 0) return i; 
		}
		return 1;
	}
	
	public static int getNokForTwoNum (int a, int b) {
		return a * b / getNodForTwoNum(a, b);
	}
}

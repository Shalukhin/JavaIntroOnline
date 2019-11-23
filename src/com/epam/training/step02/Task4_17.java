/*17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких 
действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию. */

package com.epam.training.step02;

public class Task4_17 {

	public static void main(String[] args) {
		
		int a = 581;
		
		System.out.printf("Для получения 0 необходимо провести %d операций вычитания.", subtractionSumNumb(a));

	}
	
	public static int subtractionSumNumb (int a) {
		int n = 0;
		while (a > 0) {
			n++;
			int sumA = sumNumb(a);
			System.out.printf("%2d) %d - %d = %d\n", n, a, sumA, a - sumA);
			a = a - sumA;
		}
		return n;
	}
	
	public static int sumNumb (int a) {
		int sum = 0;
		while (a != 0) {
			sum = sum + a % 10;
			a = a / 10;
		}
		return sum;
	}

}

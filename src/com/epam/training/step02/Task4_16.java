/* 16.  Написать  программу,  определяющую  сумму  n  -  значных  чисел,  содержащих  только  нечетные  цифры. 
Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию. */

package com.epam.training.step02;

public class Task4_16 {

	public static void main(String[] args) {
		
		int n = 6;
		
		long sum = getSum(n);
		
		System.out.printf("Сумма %d-значных чисел, содержащих только нечётные цифры: %d\n", n, sum);
		
		System.out.printf("В цифре %d содержится %d чётных цифр", sum, howManyEvenNumb(sum));

	}
	
	public static long getSum (int n) {
		long a = (int) Math.pow(10, n - 1);
		long b = (int) Math.pow(10, n) - 1;
		long sum = 0;
		for (long i = a; i <= b; i++) {
			if (isOnlyOddNumb(i)) {
				//System.out.println(i);
				sum = sum + i;
			}
		}
		return sum;
	}
	
	public static boolean isOnlyOddNumb (long a) {
		
		while (a != 0) {
			
			if (a % 10 % 2 == 0) {
				return false;
			}
			a = a / 10;
		}
		
		return true;
	}
	
	public static int howManyEvenNumb (long a) {
		
		int count = 0;
		
		while (a != 0) {
			
			if (a % 10 % 2 == 0) {
				count++;
			}
			
			a = a / 10;
		}
		return count;
	}

}

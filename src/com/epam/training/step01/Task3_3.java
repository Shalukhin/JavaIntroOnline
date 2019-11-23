/*3. Найти сумму квадратов первых ста чисел.*/

package com.epam.training.step01;

public class Task3_3 {

	public static void main(String[] args) {

		long sum = 0;
		int i = 3;
		
		while (i != 0) {
			sum = sum + i * i;
			i--;
		}
		
		System.out.println(sum);

	}
}

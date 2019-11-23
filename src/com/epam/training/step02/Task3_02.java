/*2. Даны две последовательности. Образовать из них новую последовательность 
чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать. */

package com.epam.training.step02;

import java.util.Arrays;

public class Task3_02 {

	public static void main(String[] args) {
		
		int[] a = {1, 2, 5, 6, 7, 8, 14, 16, 17};
		int[] b = {7, 55, 66, 93};
		
		System.out.println("Исходные массивы:\n" + Arrays.toString(a) + "\n" + Arrays.toString(b));
		
		int[] c = new int[a.length + b.length];
		
		int n = 0;
		int m = 0;
		
		for (int i = 0; i < c.length; i++) {
			
			if ((n < a.length) && (m < b.length)) {
				if (a[n] < b[m]) {
					c[i] = a[n];
					n++;
				}
				else {
					c[i] = b[m];
					m++;
				}
			}
			else if (n >= a.length) {
				c[i] = b[m];
				m++;
			}
			else {
				c[i] = a[n];
				n++;
			}						
		}
		
		System.out.println("\nРезультирующий массив:\n" + Arrays.toString(c));
	}
}

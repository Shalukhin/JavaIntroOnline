/* 
1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в один  массив,  включив  второй  массив  
между  k-м  и  (k+1)  -  м  элементами  первого, при  этом  не  используя дополнительный массив. */

package com.epam.training.step02;

import java.util.Arrays;

public class Task3_01 {

	public static void main(String[] args) {
		
		int[] a = {1, 2, 5, 8, 3, 6, 4, 6, 7};
		int[] b = {55, 66, 93};
		int k = 3;
		
		System.out.println("Исходные массивы:\n" + Arrays.toString(a) + "\n" + Arrays.toString(b));
		System.out.println("\nПозиция вставки второго масива в первый:  " + k);
		
		int[] c = new int[a.length + b.length];
		
		int count = 0;
		
		for (int i = 0; i < c.length; i++) {
			
			if (i < k) {
				c[i] = a[i];				
			}
			
			if (i >= k && i < k + b.length) {
				c[i] = b[count];
				count++;				
			}
			
			if (i >= k + b.length) {				
				c[i] = a[i-b.length];				
			}			
		}
		System.out.println("\nРезультирующий массив:\n" + Arrays.toString(c));
	}
}

/*1. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К. */

package com.epam.training.step02;

import java.util.Formatter;
import java.util.Locale;

public class Task1_01 {

	public static void main(String[] args) {
				
		int k = 3;
		int sum = 0;
		
		Formatter formatter1 = new Formatter(Locale.US);
		formatter1.format("Исходный массив:\n[");
		Formatter formatter2 = new Formatter(Locale.US);
		formatter2.format("Сумма элементов массива (кратных %d):\n", k);
		
		boolean flag = false;  // флаг для формирования вывода
		
		int n = 10;
		int[] a = new int[n];		
		
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*100);
			
			formatter1.format("%d", a[i]);
			if (i != a.length - 1) formatter1.format("; ");
			
			if (a[i] % k == 0) {							
				sum = sum + a[i];
				
				if (flag) formatter2.format(" + ");
				else flag = true;
				
				formatter2.format("%d", a[i]);				
			}
		}	
		
		formatter1.format("]\n\nK = %d\n", k);
		formatter2.format(" =\n= %d", sum);
		
		System.out.println(formatter1);
		System.out.println(formatter2);

	}

}

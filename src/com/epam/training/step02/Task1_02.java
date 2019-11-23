/*2. Дана последовательность действительных чисел а 1  ,а 2  ,..., а п. Заменить все ее члены, большие данного Z, этим 
числом. Подсчитать количество замен. */

package com.epam.training.step02;

import java.util.Formatter;
import java.util.Locale;

public class Task1_02 {

	public static void main(String[] args) {
		
		Formatter formatter1 = new Formatter(Locale.US);
		formatter1.format("Исходный массив действительных чисел:\n[");
		Formatter formatter2 = new Formatter(Locale.US);
		formatter2.format("Массив действительных чисел после замены:\n[");
		
		double z = 11;
		int count = 0;
		
		int n = 10;
		double[] a = new double[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.random()*200 - 100;
			
			formatter1.format("%.3f", a[i]);
			if (i != a.length - 1) formatter1.format("; ");	
			
			if (a[i] > z) {
				a[i] = z;
				count++;
				
				formatter2.format("%.3f", a[i]);
				if (i != a.length - 1) formatter2.format("; ");	
			}
			else {
				formatter2.format("%.3f", a[i]);
				if (i != a.length - 1) formatter2.format("; ");
			}			
		}
		
		formatter1.format("]\n\nZ = %.3f\n", z);
		formatter2.format("]\n\nКолличество замен: %d",count);
		
		System.out.println(formatter1);
		System.out.println(formatter2);
	}
}

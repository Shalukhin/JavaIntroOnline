/*4. Даны действительные числа а 1  ,а 2  ,..., а n  . Поменять местами наибольший и наименьший элементы. */

package com.epam.training.step02;

import java.util.Formatter;
import java.util.Locale;

public class Task1_04 {

	public static void main(String[] args) {
		
		Formatter formatter = new Formatter(Locale.US);
		formatter.format("Исходный массив действительных чисел:\n[");
		
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		
		int n = 10;
		double[] a = new double[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.random()*200 - 100;
			
			formatter.format("%.3f", a[i]);
			if (i != a.length - 1) formatter.format("; ");
			
			if (a[i] < min) min = a[i];
			if (a[i] > max) max = a[i];
		}		
		
		formatter.format("]\n\nМинимальное число:  %.3f\n\nМаксимальное число:  %.3f\n\nОтредактированный массив действительных чисел:\n[", min, max);
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] == min) {
				a[i] = max;
				
				formatter.format("%.3f", a[i]);
				if (i != a.length - 1) formatter.format("; ");
				
				continue;
			}
			if (a[i] == max) a[i] = min;	
			
			formatter.format("%.3f", a[i]);
			if (i != a.length - 1) formatter.format("; ");
		}
		
		formatter.format("]\n");
		
		System.out.println(formatter);
	}
}

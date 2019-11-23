/*7. Даны действительные числа a1 a2 a3 ... an. Найти max(a1+a2n, a2+a2n-1...)*/

package com.epam.training.step02;

import java.util.Formatter;
import java.util.Locale;

public class Task1_07 {

	public static void main(String[] args) {
		
		Formatter formatter1 = new Formatter(Locale.US);
		Formatter formatter2 = new Formatter(Locale.US);
		formatter1.format("Исходный массив:\n[");
		formatter2.format("Массив вида \"a(n)+a(n+1)\" :\n[");		
		
		double max = Double.MIN_VALUE;
		
		int n = 10;
		double[] a = new double[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.random()*200 - 100;
			
			formatter1.format("%.3f", a[i]);
			if (i != a.length - 1) formatter1.format("; ");
			
			if (i != 0)  {
				double s = a[i - 1] + a[i];
				
				formatter2.format("%.3f", s);
				if (i != a.length - 1) formatter2.format("; ");
				
				if (s > max) max = s;
			}
		}
		
		formatter1.format("]\n");
		formatter2.format("]\n\nМаксимальный элемент данного массива: %.3f", max);
		System.out.println(formatter1);
		System.out.println(formatter2);	
	}
}

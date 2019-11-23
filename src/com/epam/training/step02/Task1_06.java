/*6.  Задана  последовательность  N  вещественных  чисел.  Вычислить  сумму  чисел,  порядковые  номера  которых 
являются простыми числами. */

package com.epam.training.step02;

import java.util.Formatter;
import java.util.Locale;

public class Task1_06 {

	public static void main(String[] args) {
		
		Formatter formatter1 = new Formatter(Locale.US);
		Formatter formatter2 = new Formatter(Locale.US);
		
		formatter1.format("Исходный массив:\n[");
		formatter2.format("Сумма числел, порядковые номера которых являются простыми числами:\n");
		
		double sum = 0;
		boolean flag = false;  // флаг для формирования вывода
		
		int n = 10;
		double[] a = new double[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.random()*200 - 100;
			
			formatter1.format("%.3f", a[i]);
			if (i != a.length - 1) formatter1.format("; ");
			
			if (isPrimeNumber(i+1)) {
				sum = sum + a[i];
				
				if (flag) formatter2.format(" + ");
				else flag = true;
				
				formatter2.format("(%.3f)", a[i]);							
			}
		}
		
		formatter1.format("]\n");
		formatter2.format(" =\n= %.3f", sum);
		
		System.out.println(formatter1);
		System.out.println(formatter2);
	}
	
	public static boolean isPrimeNumber (int n) {
		for (int i = 2; i <= n/2; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}

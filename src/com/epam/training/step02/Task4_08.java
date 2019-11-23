/* 8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6]. 
Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов 
массива с номерами от k до m. */

package com.epam.training.step02;

import java.util.Arrays;

public class Task4_08 {

	public static void main(String[] args) {

		double[] d = getMassiv(6);
		
		System.out.println("Исходный массив:\n" + Arrays.toString(d));
		
		System.out.println("\nСумма элементов: " + sumThreeEl(d, 0));		

	}
	
	public static double[] getMassiv (int a) {
		
		double[] mas = new double[a];		
		
		for (int i = 0; i < mas.length; i++) {
			mas[i] = Math.random() * 20 - 10;
		}
		return mas;		
	}
	
	
	public static double sumThreeEl (double[] d, int k) {
		
		int m1 = k % d.length;
		int m2 = (k + 1) % d.length;
		int m3 = (k + 2) % d.length;
		
		System.out.println("\nНомера суммируемых элементов:  " + m1 + "  " + m2 + "  " + m3);
		
		return d[m1] + d[m2] + d[m3];
	}
}

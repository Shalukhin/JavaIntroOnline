/* 7. Сформировать квадратную матрицу порядка N по правилу: */

package com.epam.training.step02;

import java.lang.Math;

public class Task2_07 {

	public static void main(String[] args) {
		
		int n = 10;
		int m = n;
		int count = 0;
		double[][] matr = new double[n][m];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				
				matr[i][j] = Math.sin((double)((i+1)*(i+1) - (j+1)*(j+1))/n);
				if (matr[i][j] > 0) count++;
			}			
		}
		System.out.println("Искомая матрица:\n");
		
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {				
				System.out.printf("%5.02f ",matr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("\nКоличество положительных элементов в матрице:  " + count);
	}
}

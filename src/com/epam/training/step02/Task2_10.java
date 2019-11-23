/*10. Найти положительные элементы главной диагонали квадратной матрицы. */

package com.epam.training.step02;

import java.util.Formatter;
import java.util.Locale;

public class Task2_10 {

	public static void main(String[] args) {

		Formatter formatter = new Formatter(Locale.US);
		formatter.format("\nПоложительные элементы главной диагонали матрицы:\n");
		
		System.out.println("Исходная матрица:\n");
		
		int n = 5;
		int m = 5;
		int[][] matr = new int[n][m];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				matr[i][j] = (int)(Math.random()*18 - 9);
				System.out.printf("%2d ",matr[i][j]);
				
				if ((i == j) && (matr[i][j] > 0)) {
					formatter.format("%d; ", matr[i][j]);
				}
			}
			System.out.println();
		}

		System.out.println(formatter);
	}

}

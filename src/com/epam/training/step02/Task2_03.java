/*3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы. */

package com.epam.training.step02;

public class Task2_03 {

	public static void main(String[] args) {
		
		System.out.println("Исходная матрица:\n");
		
		int n = 5;
		int m = 5;
		int[][] matr = new int[n][m];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				matr[i][j] = (int)(Math.random()*90 + 10);
				System.out.print(matr[i][j] + " ");
			}
			System.out.println();
		}
		
		int k = 2;
		int p = 3;
		
		System.out.printf("\n%d строка и %d столбец:\n\n", k, p);
		
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				
				if (i == k-1 || j == p-1) System.out.print(matr[i][j] + " ");
				else System.out.print("   ");
			}
			System.out.println();
		}
	}
}

/* 2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали. */

package com.epam.training.step02;

public class Task2_02 {

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
		
		System.out.println("\nЭлементы, стоящие на диагонали:\n");
		
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				
				if (i == j) System.out.print(matr[i][j] + " ");
				else System.out.print("   ");
			}
			System.out.println();
		}
	}
}

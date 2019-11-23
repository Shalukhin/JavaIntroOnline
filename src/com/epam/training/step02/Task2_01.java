/*1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего. */

package com.epam.training.step02;

public class Task2_01 {

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
		
		System.out.println("\nМатрица после преобразования:\n");
		
		boolean flag = false;   //флаг разрешающий или запрещающий вывод элемента матрицы на консоль по критерию разности первого и последего элемента в столбце 
		
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				
				if (matr[0][j] - matr[matr.length-1][j] > 0) flag = true;
				
				if ((j + 1) % 2 != 0 && flag) System.out.print(matr[i][j] + " ");
				
				flag = false;
				 
			}
			System.out.println();
		}
	}
}

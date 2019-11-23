/*5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное): */

package com.epam.training.step02;

public class Task2_05 {

	public static void main(String[] args) {
				
		int n = 8;
		int m = n;
		int[][] matr = new int[n][m];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length - i; j++) {
				
				matr[i][j] = i + 1;
			}			
		}
		System.out.println("Искомая матрица:\n");
		
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {				
				System.out.print(matr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

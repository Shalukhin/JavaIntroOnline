/*12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов. */

package com.epam.training.step02;

public class Task2_12 {

	public static void main(String[] args) {		

		System.out.println("Исходная матрица:\n");
		
		int n = 5;
		int m = 5;
		int[][] matr = new int[n][m];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				matr[i][j] = (int)(Math.random()*18 - 9);
				System.out.printf("%2d ",matr[i][j]);	
			}
			System.out.println();
		}
		
		System.out.println("\nМатрица после сортировки в строках по возрастаию значений элементов:\n");
		
		for (int i = 0; i < matr.length; i++) {					//сортировка по возростанию знач.элементов в строках
			for (int j = 0; j < matr[0].length; j++) {				
				for (int k = 0; k < matr[0].length - 1 - j; k++) {
					if (matr[i][k] > matr[i][k + 1]) {
						int temp = matr[i][k];
						matr[i][k] = matr[i][k + 1];
						matr[i][k + 1] = temp;
					}
				}
			}
		}
				
		for (int i = 0; i < matr.length; i++) {          // Вывод матрицы на консоль
			for (int j = 0; j < matr[0].length; j++) {				
				System.out.printf("%2d ",matr[i][j]);
			}
			System.out.println();
		}
		
		
		System.out.println("\nМатрица после сортировки в строках по убыванию значений элементов:\n");
		
		for (int i = 0; i < matr.length; i++) {				  //сортировка по убыванию знач.элементов в строках
			for (int j = 0; j < matr[0].length; j++) {				
				for (int k = 0; k < matr[0].length - 1 - j; k++) {
					if (matr[i][k] < matr[i][k + 1]) {
						int temp = matr[i][k];
						matr[i][k] = matr[i][k + 1];
						matr[i][k + 1] = temp;
					}
				}
			}
		}		
		
		for (int i = 0; i < matr.length; i++) {          // Вывод матрицы на консоль
			for (int j = 0; j < matr[0].length; j++) {				
				System.out.printf("%2d ",matr[i][j]);
			}
			System.out.println();
		}
	}
}

/*8. В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить 
на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит 
пользователь с клавиатуры. */

package step02;

import java.util.Scanner;

public class Task2_08 {

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
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nВведите номера столбцов, которые поменяются местами:");
		int k = sc.nextInt();
		int p = sc.nextInt();
		sc.close();
		
		System.out.println("Матрица после преобразования:\n");
		
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				
				if (j == k - 1) {
					int temp = matr[i][j];
					matr[i][j] = matr[i][p - 1];
					matr[i][p - 1] = temp;
				}
				
				System.out.print(matr[i][j] + " ");				
			}
			System.out.println();
		}
	}
}

/*9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой 
столбец содержит максимальную сумму. */

package step02;

public class Task2_09 {

	public static void main(String[] args) {

		int sum = 0;
		int max_sum = 0;
		
		System.out.println("Исходная матрица:\n");
		
		int n = 5;
		int m = 5;
		int[][] matr = new int[n][m];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				matr[i][j] = (int)(Math.random()*9);
				System.out.print(matr[i][j] + "  ");	
			}
			System.out.println();
		}
		
		System.out.println("\nСуммы по столбцам:\n");
		
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {				
				sum = sum + matr[j][i];				
			}			
			System.out.print(sum + " ");
			if (sum > max_sum) max_sum = sum;
			sum = 0;
		}
		
		System.out.println("\n\nмаксимальная сумма:  " + max_sum);
	}
}

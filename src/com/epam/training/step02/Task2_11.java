/*11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в 
которых число 5 встречается три и более раз. */

package step02;

import java.util.Formatter;
import java.util.Locale;

public class Task2_11 {

	public static void main(String[] args) {
		
		Formatter formatter = new Formatter(Locale.US);
		formatter.format("\nНомера строк, в которых число 5 встречается три и более раз:\n");
		
		int count = 0;

		System.out.println("Исходная матрица:\n");
		
		int n = 10;
		int m = 20;
		int[][] matr = new int[n][m];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				matr[i][j] = (int)(Math.random()*15);
				System.out.printf("%2d  ",matr[i][j]);
				
				if (matr[i][j] == 5) count++;
				
			}
			System.out.println();
			if (count >= 3) formatter.format("%d; ", i);
			count = 0;
		}
		
		System.out.println(formatter);

	}

}

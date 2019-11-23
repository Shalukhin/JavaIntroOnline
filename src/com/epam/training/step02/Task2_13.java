/*13. Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов. */

package step02;

public class Task2_13 {

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
		
		System.out.println("\nМатрица после сортировки в столбцах по возрастаию значений элементов:\n");
		
		for (int i = 0; i < matr[0].length; i++) {					//сортировка по возростанию знач.элементов в столбцах
			for (int j = 0; j < matr.length; j++) {				
				for (int k = 0; k < matr.length - 1 - j; k++) {
					if (matr[k][i] > matr[k + 1][i]) {
						int temp = matr[k][i];
						matr[k][i] = matr[k + 1][i];
						matr[k + 1][i] = temp;
					}
				}
			}
		}
				
		for (int i = 0; i < matr.length; i++) {          // Вывод матрицы на консоль
			for (int j = 0; j < matr[0].length; j++) {				
				System.out.printf("%2d ", matr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("\nМатрица после сортировки в столбцах по убыванию значений элементов:\n");
		
		for (int i = 0; i < matr[0].length; i++) {					//сортировка по возростанию знач.элементов в столбцах
			for (int j = 0; j < matr.length; j++) {				
				for (int k = 0; k < matr.length - 1 - j; k++) {
					if (matr[k][i] < matr[k + 1][i]) {
						int temp = matr[k][i];
						matr[k][i] = matr[k + 1][i];
						matr[k + 1][i] = temp;
					}
				}
			}
		}
				
		for (int i = 0; i < matr.length; i++) {          // Вывод матрицы на консоль
			for (int j = 0; j < matr[0].length; j++) {				
				System.out.printf("%2d ", matr[i][j]);
			}
			System.out.println();
		}
	}
}

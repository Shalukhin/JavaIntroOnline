/* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное): */

package step02;

public class Task2_04 {

	public static void main(String[] args) {
		
		System.out.println("Искомая матрица:\n");
		
		int n = 8;
		int m = n;
		int[][] matr = new int[n][m];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {
				
				if (i % 2 == 0) matr[i][j] = j+1;
				else matr[i][j] = matr.length - j;
				
				System.out.print(matr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

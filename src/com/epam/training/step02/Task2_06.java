/*6. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное): */

package step02;

public class Task2_06 {

	public static void main(String[] args) {
		
		int n = 8;
		int m = n;
		int[][] matr = new int[n][m];
		int i;
		for (i = 0; i < matr.length - i; i++) {
			for (int j = i; j < matr[0].length - i; j++) {
				
				matr[i][j] = 1;
			}			
		}
		
		for (; i < matr.length; i++) {
			for (int j = matr[0].length-i-1; j < i+1; j++) {
				
				matr[i][j] = 1;
			}			
		}
		
		System.out.println("Искомая матрица:\n");
		
		for (i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {				
				System.out.print(matr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

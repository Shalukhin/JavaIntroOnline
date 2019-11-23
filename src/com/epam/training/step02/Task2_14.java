/*14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число 
единиц равно номеру столбца. */

package step02;

public class Task2_14 {

	public static void main(String[] args) {
		

		System.out.println("Искомая матрица:\n");				
		int m = 5;
		int n = 10;
		int[][] matr = new int[n][m];
		for (int i = 0; i < matr[0].length; i++) {			
			boolean flag = true;
			while (flag) {
				int count = 0;
				for (int j = 0; j < matr.length; j++) {					
					matr[j][i] = (int)(Math.random()*2);					
					if (matr[j][i] == 1) count++;				
				}
				if (count == i + 1) flag = false;				
			}			
		}
		
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[0].length; j++) {				
				System.out.printf("%2d ",matr[i][j]);	
			}
			System.out.println();
		}		
	}
}

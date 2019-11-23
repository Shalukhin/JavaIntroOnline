/*2. Вычислить значения функции на отрезке [а,b] c шагом h: */

package step01;

public class Task3_2 {

	public static void main(String[] args) {
		
		double a = -5;
		double b = 6;
		double h = 0.5;
		double y;
		
		for (double x = a; x <= b; x = x + h ) {
			if (x > 2) y = x;			
			else y = -x;
			System.out.println("x = " + x + "   y = " + y);
		}
	}
}

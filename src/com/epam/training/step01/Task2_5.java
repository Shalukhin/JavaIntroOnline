/*5. Вычислить значение функции: */

package step01;

public class Task2_5 {

	public static void main(String[] args) {
		
		double x = 2.45;
		double y;
		
		if (x <= 3) y = x * x - 3 * x + 9;
		else y = 1 / (x * x * x + 6);
		
		System.out.println(y);

	}
}

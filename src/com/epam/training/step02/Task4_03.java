/* 3.  Вычислить  площадь  правильного  шестиугольника  со  стороной  а,  используя  метод  вычисления  площади треугольника. */

package step02;

import java.util.Scanner;

public class Task4_03 {

	public static void main(String[] args) {
		
		double a = getLengthSideHexagon();
		
		System.out.printf("\nПлощадь шестиугольника равна:  %.3f",getSquareHexagon(a));
	}
	
	public static double getLengthSideHexagon () {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Введите сторону правильного шестиугольника, a = ");
		
		while (!sc.hasNextDouble()) {
			sc.next();			
			System.out.println("Введите сторону правильного шестиугольника, a = ");
		}
		double a = Math.abs(sc.nextDouble());
		System.out.printf("Принято, сторона a = %.3f\n", a);
		return a;
	}
	
	public static double getSquareHexagon (double a) {
		return a * a * 3 * Math.sqrt(3) / 2;
	}
}

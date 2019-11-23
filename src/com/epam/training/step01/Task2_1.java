/*1. Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли 
он прямоугольным. */

package step01;

public class Task2_1 {

	public static void main(String[] args) {
		
		double alpha = 45;
		double betta = 45;
		
		if ((alpha + betta) >= 180) {
			System.out.println("треугольник не существует");
			return;
		}
		else if (((alpha + betta) == 90) || alpha == 90 || betta == 90) {
			System.out.println("треугольник существует и является прямоугольным");
			return;
		}
		else {
			System.out.println("треугольник существует и не является прямоугольным");			
		}
	}
}

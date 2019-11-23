/*4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через 
отверстие. */

package com.epam.training.step01;

public class Task2_4 {

	public static void main(String[] args) {
		
		double a = 65;
		double b = 100;
		
		double x = 250;
		double y = 120;
		double z = 65;
		
		
		if (x <= a)  {
			if (y <= b) {
				System.out.println("пролезет по x - y");
				return;
			}
			if (z <= b) {
				System.out.println("пролезет по x - z");
				return;
			}
		}
		if (x <= b) {
			if (y <= a) {
				System.out.println("пролезет по y - x");
				return;
			}
			if (z <= a) {
				System.out.println("пролезет по z - x");
				return;
			}
		}
		
		if (y <= a)  {			
			if (z <= b) {
				System.out.println("пролезет по y - z");
				return;
			}
		}
		if (y <= b) {
			if (z <= a) {
				System.out.println("пролезет по z - y");
				return;
			}
		}
		
		System.out.println("не пролезет");
	}
}

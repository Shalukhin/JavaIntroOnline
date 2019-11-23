/* 9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади, 
если угол между сторонами длиной X и Y— прямой. */

package com.epam.training.step02;

import java.util.Scanner;

public class Task4_09 {

	public static void main(String[] args) {

		System.out.println("Сторона X четырёхугольника");
		double x = getDoubleNumberFromConsol();
		System.out.println("\nСторона Y четырёхугольника");
		double y = getDoubleNumberFromConsol();
		System.out.println("\nСторона Z четырёхугольника");
		double z = getDoubleNumberFromConsol();
		
		double t;
		while (true) {
			System.out.println("\nСторона T четырёхугольника должна быть больше " + minT(x, y, z));
			t = getDoubleNumberFromConsol();
			if (t > minT(x, y, z)) {
				break;
			}
		}
		
		System.out.printf("\nПлощадь четырёхугольника равна %.3f", square(x, y, z, t));

	}
	
	public static double getDoubleNumberFromConsol () {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите число:");
		while (!sc.hasNextDouble()) {
			sc.next();
			System.out.println("Ошибка. Введите число ещё раз:");
		}
		double num = sc.nextDouble();
		System.out.println("Принято. Вы ввели число " + num);
		return Math.abs(num);
	}
	
	public static double minT (double x, double y, double z) {
		double h = hyp(x, y);
		return h - z < 0 ? 0 : h - z;
	}
	
	public static double hyp (double x, double y) {
		
		return Math.sqrt(x * x + y * y);
	}
	
	public static double square (double x, double y, double z, double t) {
		
		double h = hyp(x, y);
		double p = (h + z + t) / 2;
		
		return x * y / 2 + Math.sqrt(p * (p - h) * (p - z) * (p - t));		
	}

}

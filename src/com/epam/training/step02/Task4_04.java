/*4. На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими из пар точек самое большое расстояние. Указание. Координаты точек занести в массив. */

package com.epam.training.step02;

import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class Task4_04 {

	public static void main(String[] args) {		

		int n = getNumberPoints();  //вводим целое число - колличество точек
		
		Point[] points = getPoints(n);    //получаем массив объектов типа Point размером n
		
		printPoints(points);		// выводим набор точек на консоль
		
		Point[] max_points = getTwoPointMaxDistance(points);		// определяем две наиболее удалёные точки
		
		if (max_points != null) {		// выводим на консоль две наиболее удалёные точки, если они найдены
			
			System.out.printf("\nМаксимальное расстояние r = %.3f между точками:\n", max_points[0].getDistance(max_points[1]));			
			printPoints(max_points);
		}
		
		else {
			System.out.println("\nТочки отсутствуют или их меньше двух");
		}		
	}
	
	public static class Point {
		int id;
		double x;
		double y;
		
		public Point() {
			super();
		}
		
		public Point(int id, double x, double y) {
			this();
			this.id = id;
			this.x = x;
			this.y = y;
		}
		
		public double getDistance (Point pt) {
			
			return Math.sqrt((pt.x - this.x) * (pt.x - this.x) + (pt.y - this.y) * (pt.y - this.y));
		}
		
		@Override
		public String toString() {
			@SuppressWarnings("resource")
			Formatter ft = new Formatter(Locale.US);
			ft.format("point %03d: x = %7.3f; y = %7.3f\n", id, x, y);
			return ft.toString();
		}		
	}
	
	public static int getNumberPoints () {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите количество точек: n = ");
		if (!sc.hasNextInt()) {
			sc.next();
			System.out.println("Введите количество точек: n = ");
		}
		return Math.abs(sc.nextInt());
	}
	
	public static Point[] getPoints (int n) {
		Point[] points = new Point[n];
		for (int i = 0; i < points.length; i++) {
			points[i] = generateRndPoint(i);
		}
		return points;
	}
	
	public static Point generateRndPoint(int id) {
		
		return new Point(id, Math.random() * 40 - 20, Math.random() * 40 - 20);
	}
	
	public static void printPoints (Point[] pt) {
		
		for (int i = 0; i < pt.length; i++) {
			System.out.print(pt[i].toString());
		}
	}
	
	public static Point[] getTwoPointMaxDistance (Point[] pt) {
		
		if (pt.length < 2) return null;
		
		double max = 0;
		int n = 0;
		int m = 0;
		
		for (int i = 0; i < pt.length - 1; i++) {
			for (int j = i; j < pt.length; j++) {
				double dist = pt[i].getDistance(pt[j]);
				if (max < dist) {
					max = dist;
					n = i;
					m = j;
				}
			}
		}
		
		Point[] max_poitns = {pt[n], pt[m]};
		return max_poitns;			
	}	

}

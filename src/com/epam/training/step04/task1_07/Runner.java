/*7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления 
площади, периметра и точки пересечения медиан.*/

package com.epam.training.step04.task1_07;

public class Runner {

	public static void main(String[] args) {
		
		Triangle triangle = new Triangle(1, 1, 2, 2, 3, 3);
		
		System.out.println(triangle);
		
		triangle.a = new Point(-1, 0);
		triangle.b = new Point(8, 1);
		triangle.c = new Point(5, 9);
		
		System.out.println(triangle);
		System.out.printf("Площадь треугольника: %.2f\n", triangle.getSquare());
		System.out.printf("Периметр треугольника: %.2f\n", triangle.getPerimeter());
		System.out.printf("Координаты точки пересечения медиан: %s", triangle.getMedian());		
	}
}

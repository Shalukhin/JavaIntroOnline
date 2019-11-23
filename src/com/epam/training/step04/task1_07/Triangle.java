/*7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления 
площади, периметра и точки пересечения медиан.*/

package com.epam.training.step04.task1_07;

public class Triangle {

	Point a;
	Point b;
	Point c;

	public Triangle() {
		super();
		a = new Point(0, 0);
		b = new Point(1, 0);
		c = new Point(0, 1);
	}

	public Triangle(Point a, Point b, Point c) {
		this();
		if (a.isBelongsStraight(b, c)) {
			System.out.println("Из данных точек невозможно создать треугольник! Создан стандартный треугольник!");
		} else {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this (new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
	}

	public double getSquare() {
		return Math.abs(((a.x - c.x) * (b.y - c.y) - (a.y - c.y) * (b.x - c.x)) / 2);
	}
	
	public double getPerimeter() {
		return a.distanceTo(b) + b.distanceTo(c) + a.distanceTo(c);
	}
	
	public Point getMedian() {
		return new Point((a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3);
	}
	
	public String toString() {
		return String.format("Вершины треугольника:\nA(%s)\nB(%s)\nC(%s)", a.toString(), b.toString(), c.toString());
	}

}

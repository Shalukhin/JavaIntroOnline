/*7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления 
площади, периметра и точки пересечения медиан.*/

package step04.task1_07;

public class Point {
	
	double x;
	double y;	
	
	public Point() {
		super();
		x = 0;
		y = 0;
	}

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double distanceTo (Point point) {
		
		return Math.sqrt((point.x - x) * (point.x - x) + (point.y - y) * (point.y - y));
	}
	
	public boolean isBelongsStraight (Point first, Point last) {
		if ((x - first.x) / (last.x - first.x) == (y - first.y) / (last.y - first.y)) {
			return true;
		} else {
			return false;
		}		
	}
	
	public String toString() {
		return String.format("x = %.2f; y = %.2f", x, y);
	}

}

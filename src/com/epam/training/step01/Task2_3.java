/*3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.*/

package step01;

public class Task2_3 {

	public static void main(String[] args) {
		
		double xA = 1;  //координаты точки A
		double yA = 2;
		
		double xB = 3;  //координаты точки B
		double yB = 4;
		
		double xC = 5;  //координаты точки C
		double yC = 6;
		
		double xAB = xB - xA;  //координаты вектора AB
		double yAB = yB - yA;
		
		double xBC = xC - xA;  //координаты вектора BC
		double yBC = yC - yA;
		
		if ((xAB / xBC) == (yAB / yBC)) System.out.println("точки лежат на одной прямой");   // проверка коллиниарности векторов
		else System.out.println("точни не лежат на одной прямой");

	}

}

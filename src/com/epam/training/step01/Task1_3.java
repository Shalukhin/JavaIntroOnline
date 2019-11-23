/*3. Вычислить значение выражения по формуле (все переменные принимают действительные значения): */

package step01;

import java.lang.Math;

public class Task1_3 {

	public static void main(String[] args) {
		
		double x = 1.5;
		double y = 2.2;
		
		System.out.println((Math.sin(x) + Math.cos(y) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y)));

	}

}

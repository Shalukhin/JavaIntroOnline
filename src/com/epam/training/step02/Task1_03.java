/*3.  Дан  массив  действительных  чисел,  размерность  которого  N.  Подсчитать,  сколько  в  нем  отрицательных, 
положительных и нулевых элементов. */

package step02;

import java.util.Formatter;
import java.util.Locale;

public class Task1_03 {

	public static void main(String[] args) {
		
		Formatter formatter = new Formatter(Locale.US);
		formatter.format("Исходный массив действительных чисел:\n[");
		
		int positive = 0;
		int negotive = 0;
		int zero = 0;
		
		int n = 10;
		double[] a = new double[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.random()*200 - 100;
			
			formatter.format("%.3f", a[i]);
			if (i != a.length - 1) formatter.format("; ");
			
			if (a[i] < 0) negotive++;
			else if (a[i]> 0) positive++;
			else zero++;			
		}
		formatter.format("]\n\nКолличество отрицательных:  %d\nКоличество положительных:  %d\nКолличество нулевых:  %d", negotive, positive, zero);
		System.out.println(formatter);		
	}
}

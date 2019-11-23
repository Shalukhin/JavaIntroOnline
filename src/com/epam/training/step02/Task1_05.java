/*5. Даны целые числа а 1  ,а 2  ,..., а n  . Вывести на печать только те числа, для которых а i  > i. */

package step02;

import java.util.Formatter;
import java.util.Locale;

public class Task1_05 {

	public static void main(String[] args) {
		
		Formatter formatter1 = new Formatter(Locale.US);
		Formatter formatter2 = new Formatter(Locale.US);
		
		formatter1.format("Исходный массив:\n[");
		formatter2.format("Элементы масива для которых a[i]>i :\n[");
		
		int n = 10;
		int[] a = new int[n];		
		
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*10);
			
			formatter1.format("%d", a[i]);
			if (i != a.length - 1) formatter1.format("; ");
			
			if (a[i] > i+1) formatter2.format("%d", a[i]);
			else formatter2.format(" ");
			
			if (i != a.length-1) formatter2.format(", ");		
		}
		
		formatter1.format("]\n");
		formatter2.format("]\n");
		
		System.out.println(formatter1);
		System.out.println(formatter2);
	}
}

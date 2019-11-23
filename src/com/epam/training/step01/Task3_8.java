/*8. Даны два числа. Определить цифры, входящие в запись как первого так и второго числа. */

package step01;

import java.util.Arrays;

public class Task3_8 {

	public static void main(String[] args) {
		long i = 12345;
		long j = 56789;
		
		long[] rez = new long[0];
		long c = i;		
		long d;
		long f;
		
		while (c != 0) {
			d = c % 10;		
			c = c / 10;
		
			long e = j;
			while (e != 0) {				
				f = e % 10;
				if (f == d) {
					boolean flag = true;
					for (int k = 0; k < rez.length; k++) {
						if (rez[k] == f) {
							flag = false;
							break;
						}
					}
					if (flag) {
						rez = Arrays.copyOf(rez, rez.length+1);
						rez[rez.length-1] = f;
					}			
				
				}
				e = e / 10;
			}
		}
		
		System.out.println("Числа присутствующие в двух цифрах:\n" + Arrays.toString(rez));	
	}
}

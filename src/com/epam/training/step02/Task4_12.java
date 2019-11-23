/*12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого 
являются числа, сумма цифр которых равна К и которые не большее N. */

package step02;

import java.util.Arrays;

public class Task4_12 {

	public static void main(String[] args) {
		
		int k = 50;
		int n = 100;
		
		System.out.printf("K = %d\nN = %d\nМассив чисел A, которые не больше N (%2$d) и сумма цифр которых равна K (%1$d):\n", k, n);
		System.out.println(Arrays.toString(getMassiv(k, n)));
	}
	
	public static int[] getMassiv (int k, int n) {
		int[] mas = new int[0];
		int sum = 0;
		while (sum != k) {
			int rnd = (int)(Math.random() * (n + 1));
			int sumRnd = sumNumb(rnd);
			if (sum + sumRnd <= k ) {
				mas = Arrays.copyOf(mas, mas.length + 1);
				mas[mas.length - 1] = rnd;
				sum = sum + sumRnd;
			}
		}
		return mas;
	}
	
	public static int sumNumb (int numb) {
		
		int sum = 0;
		while (numb != 0) {
			sum = sum + numb % 10;
			numb = numb / 10;
		}		
		return sum;
	}

}

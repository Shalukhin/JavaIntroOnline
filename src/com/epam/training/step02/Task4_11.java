/* 11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр. */

package step02;

public class Task4_11 {

	public static void main(String[] args) {
		
		long a = 12345;
		long b = 12345678;
		
		System.out.printf("Первое число = %d\nВторое число = %d\n", a, b);
		
		System.out.printf("\nБольше цифр в числе:  %d", longerNumber(a, b));
		
	}
	
	public static long longerNumber (long a, long b) {
		
		return countNumb(a) > countNumb(b) ? a : b;
	}
	
	public static int countNumb (long n) {
		int count = 0;
		
		while (n != 0) {
			count++;
			n = n / 10;			
		}
		
		return count;
	}

}

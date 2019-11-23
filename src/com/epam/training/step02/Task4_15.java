/* 15.  Найти  все  натуральные  n-значные  числа,  цифры  в  которых  образуют  строго  возрастающую 
последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию. */

package step02;

import java.util.Arrays;
import java.util.Scanner;

public class Task4_15 {

	public static void main(String[] args) {
		
		int n = getCheckN();
		
		System.out.println("Все числа с возрастающей последовательностью цифр:\n" + Arrays.toString(getUpUpNumber(n)));
	}
	
	public static int getCheckN () {
		while (true) {
			int n = getIntNumberFromConsol();
			if (n > 0 && n < 10) {
				return n;
			}
			else {
				System.out.println("Ошибка. Число должно быть от 1 до 9");
			}
		}
	}
	
	public static int getIntNumberFromConsol () {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите целое число от 1 до 9:");
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.println("Ошибка. Введите число ещё раз:");
		}
		int num = sc.nextInt();
		System.out.println("Вы ввели число " + num);
		return Math.abs(num);
	}
	
	public static int[] getUpUpNumber (int n) {
		
		int[] mas = new int[10 - n];
		
		for (int i = 1; i <= 10 - n; i++) {
			
			int temp = i;
			
			for (int j = 1; j < n; j++) {
				temp = temp * 10 + i + j;
			}
			
			mas[i - 1] = temp;
		}
		
		return mas;
	}

}

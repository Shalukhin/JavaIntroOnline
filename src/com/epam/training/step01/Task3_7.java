/*7. Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа. 
m и n вводятся с клавиатуры. */

package com.epam.training.step01;

import java.util.Scanner;

public class Task3_7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Введите начало промежутка (например \"3\"):");
		int m = sc.nextInt();
		
		System.out.println("Введите конец промежутка (например \"100\"):");
		int n = sc.nextInt();
		
		sc.close();
		
		boolean flag;		// флаг для удобного вывода на консоль "делителей нет" там где нужно
		
		for (int i = m; i < n; i++) {
			flag = true;
			System.out.print("Делители числа " + i + ": ");
			for (int j = 2; j < Math.abs(i); j++) {
				if (i % j == 0) {
					System.out.print(j + "  ");
					flag = false;
				}
			}
			if (flag) System.out.print("делителей нет\n");
			else System.out.print("\n");
		}

	}

}

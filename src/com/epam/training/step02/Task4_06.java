/* 6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.*/

package com.epam.training.step02;

import java.util.Arrays;
import java.util.Scanner;

public class Task4_06 {

	public static void main(String[] args) {
		
		int a = getIntNumberFromConsol();
		
		int b = getIntNumberFromConsol();
		
		int c = getIntNumberFromConsol();
		
		System.out.println("\nВведённые числа:");
		System.out.println(a + "   " + b + "   " + c + "\n");
		
		System.out.println("Цисла называются взаимно простыми, если они не имеют никаких общих делителей, кроме 1");
		
		int[] m = {a, b, c};
		
		if (isSimpleTogether(m)) {
			System.out.println("Данные числа являются взаимно простыми");
		}
		else {
			System.out.println("Данные числа не являются взаимно простыми");
		}		
	}
	
	public static int getIntNumberFromConsol () {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите целое число:");
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.println("Ошибка. Введите целое число ещё раз:");
		}
		int num = sc.nextInt();
		System.out.println("Принято. Вы ввели число " + num);
		return Math.abs(num);
	}
	
	public static int[] getDivides (int a) {
		
		int[] d = {1};
		
		for (int i = 2; i <= a; i++ ) {
			
			if (a % i == 0) {
				
				d = Arrays.copyOf(d, d.length + 1);
				d[d.length - 1] = i;
			}
		}
		
		return d;		
	}
	
	public static boolean isSimpleTogether (int[] m) {
		
		System.out.println("Делители введённых чисел:");
		
		int[][] dev = new int[m.length][];
		
		for (int i = 0; i < m.length; i++) {
			dev[i] = getDivides(m[i]);
			System.out.printf("%d: %s \n", m[i], Arrays.toString(dev[i]));
		}		
		
		for (int i = 0; i < dev.length - 1; i++) {
			for (int j = 1; j < dev[i].length; j++) {
				
				for (int k = i + 1; k < dev.length; k++) {
					for (int l = 1; l < dev[k].length; l++) {
						
						if (dev[i][j] == dev[k][l]) {
							return false;
						}
					}
				}
				
			}
		}		
		
		return true;		
	}
}

/* 10.  Дано  натуральное  число  N.  Написать  метод(методы)  для  формирования  массива,  элементами  которого 
являются цифры числа N. */

package com.epam.training.step02;

import java.util.Arrays;

public class Task4_10 {

	public static void main(String[] args) {
		
		long n = 1234506789;
		
		System.out.println("Исходное число N:  " + n);
		
		System.out.println("\nМассив из цифр числа N:\n" + Arrays.toString(splitN(n)));

	}
	
	public static int[] splitN (long n) {
		int[] mas = new int[0];
		while (n != 0) {
			mas = Arrays.copyOf(mas, mas.length + 1);
			mas[mas.length - 1] = (int) (n % 10);
			n = n / 10;			
		}
		
		int[] rez = new int[mas.length];
		for (int i = 0; i < rez.length; i++) {
			rez[i] = mas[mas.length - 1 - i];
		}
		return rez;
	}

}

/* 3. Сортировка выбором. Дана последовательность чисел. Требуется переставить элементы так, чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший 
элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура повторяется. Написать алгоритм сортировки выбором. */

package com.epam.training.step02;

import java.util.Arrays;

public class Task3_03 {

	public static void main(String[] args) {
		
		int[] a = {1, 2, 5, 6, 7, 8, 14, 16, 17};
		
		System.out.println("Исходный массив:\n" + Arrays.toString(a));
		
		for (int i = 0; i < a.length; i++) {
			
			int max = a[i];
			int max_val = i;
			
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > max) {
					max = a[j];
					max_val = j;
				}				
			}
			
			int temp = a[i];
			a[i] = a[max_val];
			a[max_val] = temp;
		}
		
		System.out.println("\nРезультирующий массив:\n" + Arrays.toString(a));
	}
}

/* 4.  Сортировка  обменами.  Дана  последовательность  чисел.Требуется  переставить  числа  в порядке  возрастания.  Для  этого  сравниваются  два  соседних  числа Если больше то  делается 
перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания. Составить алгоритм сортировки, подсчитывая при этом количества перестановок. */

package com.epam.training.step02;

import java.util.Arrays;

public class Task3_04 {

	public static void main(String[] args) {		

		int[] a = {10, 7, 5, 6, 1, 8, 14, 9, 1};
		
		System.out.println("Исходный массив:\n" + Arrays.toString(a));
		
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				
				if (a[j] > a[j + 1]) {
					
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					
				}
			}
		}
		
		System.out.println("\nРезультирующий массив:\n" + Arrays.toString(a));
	}
}

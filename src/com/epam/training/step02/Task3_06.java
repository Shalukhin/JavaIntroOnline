/* 6.  Сортировка  Шелла.  Дан  массив  n  действительных  чисел.  Требуется  упорядочить  его  по  возрастанию. 
Делается это следующим образом: сравниваются два соседних элемента . Если меньше, то продвигаются на  один  элемент  вперед.  Если больше,  
то  производится  перестановка  и  сдвигаются  на  один  элемент  назад. Составить алгоритм этой сортировки. */

package com.epam.training.step02;

import java.util.Arrays;

public class Task3_06 {

	public static void main(String[] args) {		

		int[] a = {10, 7, 5, 6, 1, 8, 14, 9, 1};		
		
		System.out.println("Исходный массив:\n" + Arrays.toString(a));
		
		int i = 0;
		while (i < a.length - 1) {
			
			if (a[i] > a[i+1]) {
				
				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
				
				if (i != 0) i--;
			}
			else {
				i++;
			}			
		}
		
		System.out.println("\nРезультирующий массив:\n" +Arrays.toString(a));
	}
}

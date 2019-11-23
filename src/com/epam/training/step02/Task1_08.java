/*8.  Дана  последовательность  целых  чисел a1 a2 ... an. Образовать  новую  последовательность,  выбросив  из 
исходной те члены, которые равны min(a1 a2 ... an)*/

package step02;

import java.util.Arrays;

public class Task1_08 {

	public static void main(String[] args) {
		
		int min = Integer.MAX_VALUE;
		
		int n = 10;
		int[] a = new int[n];		
		
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*100);
			
			if (a[i] < min) min = a[i];			
		}
		
		int count_min = 0;			// Колличество минимальных элементов в массиве
		for (int i = 0; i < a.length; i++) {
			if (a[i] == min) count_min++;
		}
		
		int j = 0;		// Счётчик для проходки нового массива
		int[] b = new int[a.length - count_min];
		for (int i = 0; i < a.length; i++) {
			if (a[i] != min) {
				b[j] = a[i];
				j++;
			}
		}
		
		System.out.println("Исходный массив:\n" + Arrays.toString(a) + "\n\nМинимальный элемент массива:  " + min + "\n\nКолличество минимальных элементов в массиве:  " + count_min + "\n");
		System.out.println("Итоговый массив:\n" + Arrays.toString(b));

	}

}

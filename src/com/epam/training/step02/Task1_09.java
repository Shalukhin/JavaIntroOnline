/* 9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких 
чисел несколько, то определить наименьшее из них.*/

package step02;

import java.util.Arrays;

public class Task1_09 {

	public static void main(String[] args) {
		
		//int[] a = {0,0,0,0,2,3,2,5,6,3,5,4,9,8,6,7,2,3,9,9,3};
		
		int n = 100;
		int[] a = new int[n];		
		
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*100);
		}
		
		int[] number_appear = new int[a.length];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] == a[j]) number_appear[i]++;
			}
		}
		
		int max_number_appear = 0;
		
		for (int i : number_appear) {
			if (i > max_number_appear) max_number_appear = i;
		}
		
		int count_max_number_appear = 0;
		
		for (int i : number_appear) {
			if (i == max_number_appear) count_max_number_appear++;
		}
		
		int[] often_members = new int[count_max_number_appear/max_number_appear];
		int k = 0;
		for (int i = 0; i < number_appear.length; i++) {
			if (k == often_members.length) break;			
			if (number_appear[i] == max_number_appear) {
				boolean flag = true;
				for (int j = 0; j < often_members.length; j++) {					
					if (a[i] == often_members[j]) {
						flag = false;
						break;
					}
				}
				
				if (flag) {
					often_members[k] = a[i];
					k++;
				}
			}			
		}
		
		int min_often_member = Integer.MAX_VALUE;
		for (int i = 0; i < often_members.length; i++) {
			if (often_members[i] < min_often_member) min_often_member = often_members[i];
		}
		
		System.out.println("Исходный массив:\n" + Arrays.toString(a));		
		System.out.println("\nМаксимальная частота появления одного и того же элемента:  " + max_number_appear);		
		System.out.println("\nЭлементы с максимальой частотой появления:\n" + Arrays.toString(often_members));
		System.out.println("\nЭлемент с минимальным значением среди них:  " + min_often_member);
	}
}

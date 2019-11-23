/*7.  Пусть  даны  две  неубывающие  последовательности  действительных  чисел.
Требуется указать те места, на которые нужно вставлять элементы последовательности в первую 
последовательность так, чтобы новая последовательность оставалась возрастающей. */

package com.epam.training.step02;

import java.util.Arrays;

public class Task3_07 {

	public static void main(String[] args) {
		
		int[] a = {-5, 1, 2, 5, 6, 7, 8, 14, 18, 20, 100};
		int[] b = {-11, 0, 0, 4, 7, 9, 15, 16, 93, 200, 300, 400};
		
		System.out.println("Исходные массивы:\nМассив a[]:  " + Arrays.toString(a) + "\nМассив b[]:  " + Arrays.toString(b));
		
		int[] poz = new int[b.length];
		
		
		System.out.println("\nЧтобы последовательность осталась возрастающей, необходимо из массива b[]:\n");
		
		for (int i = 0; i < b.length; i++) {
			poz[i] = dihotom_val(a, b[i]);
		
			if (i == 0) {
				System.out.printf("элементы {  %d  ", b[i]);
				continue;
			}
			
			if ((poz[i - 1]) != poz[i]) {
				
				if (poz[i - 1] == 0) {
					System.out.printf("} поместить перед %d-ым элементом массива a[];\nэлементы {  %d  ", poz[i-1]+1, b[i]);
				}
				
				else {
					System.out.printf("} поместить между %d и %d элементами массива a[];\nэлементы {  %d  ",poz[i-1], poz[i-1]+1, b[i]);
				}
			}
			else {
				System.out.printf("%d  ", b[i]);
			}
			
			if (i == poz.length-1) {
				
				if (poz[i] == 0) {
					System.out.printf("} поместить перед %d-ым элементом массива a[].\n", poz[i]+1);
				}
				
				else if (poz[i] == a.length) {
					System.out.printf("} поместить после %d-го (последнего) элемента массива a[].\n",poz[i]);
				}
				
				else {
					System.out.printf("} поместить между %d и %d элементами массива a[].\n",poz[i], poz[i]+1);
				}				
			}
		}		
	}
	
	public static int dihotom_val (int[] a, int val) {
		
		if (a[a.length-1] <= val) return a.length;
		
		int s = 0;
		int f = a.length - 1;
		
		while (s != f) {
			
			if (a[(f + s) / 2] < val) {
				s = (f + s) / 2 + 1;							
			}
			else {				
				f = (f + s) / 2;			
			}			
		}
		
		return s;		
	}
}

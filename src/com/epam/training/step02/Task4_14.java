/* 14.  Натуральное  число,  в  записи  которого  n  цифр,  называется  числом  Армстронга,  если  сумма  его  цифр, 
возведенная  в  степень  n,  равна  самому  числу.  Найти  все  числа  Армстронга  от  1  до  k.  Для  решения  задачи 
использовать декомпозицию. */

package com.epam.training.step02;

import java.util.Arrays;

public class Task4_14 {

	public static void main(String[] args) {
		
		int k = 10000;
		
		System.out.printf("Числа Армстронга в промежутке от 1 до %d:\n%s", k, Arrays.toString(getArmstrong(k)));
	}
	
	public static int[] getArmstrong (int k) {
		int[] rez = new int[0];
		
		for (int i = 0; i <= k; i++) {
			if (isArmstrongNumb(i)) {
				rez = Arrays.copyOf(rez, rez.length + 1);
				rez[rez.length - 1] = i;
			}
		}
		
		return rez;
	}
	
	public static boolean isArmstrongNumb (int a) {
		
		int sum = 0;
		int count = 0;
		int copyA = a;
		while (copyA != 0) {
			count++;
			sum = sum + copyA % 10;
			copyA = copyA / 10;
		}
		if (Math.pow(sum, count) == a) {
			return true;
		}
		else {
			return false;
		}
	}

}

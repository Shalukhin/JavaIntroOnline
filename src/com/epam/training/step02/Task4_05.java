/* 5. Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число, которое меньше максимального элемента массива, но больше всех других элементов). */

package com.epam.training.step02;

import java.util.Scanner;

public class Task4_05 {

	public static void main(String[] args) {
		
		int n = getNumberElements();
		
		double[] array = getArray(n);
		
		System.out.printf("\nИсходный массив:\n");
		
		printArray(array);
		
		System.out.printf("\nВторое по величине число в массиве:\n%.3f", getPreMaxVal(array));
	}
	
	public static int getNumberElements () {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите число элементов массова: n = ");
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.println("Введите число элементов массова: n = ");
		}
		return Math.abs(sc.nextInt());
	}
	
	public static double[] getArray (int n) {
		
		double[] arr = new double[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.random() * 200 - 100;
		}
		
		return arr;
	}
	
	public static double getPreMaxVal (double[] arr) {
		
		double max = arr[0];
		double min = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {				
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		
		double pre_max = min;
		
		for (int i = 0; i < arr.length; i++) {
			if ((pre_max < arr[i]) && (arr[i] < max )) {
				pre_max = arr[i];
			}
		}
		
		return pre_max;
	}
	
	public static void printArray (double[] arr) {
		
		System.out.print("[");
		for (int i = 0; i < arr.length-1; i++) {
			System.out.printf("%.3f; ", arr[i]);
		}
		System.out.printf("%.3f]\n", arr[arr.length-1]);		
	}
}

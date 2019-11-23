/*1. Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует 
все числа от 1 до введенного пользователем числа.*/

package com.epam.training.step01;

import java.util.Scanner;

public class Task3_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		System.out.println("Введите любое положительное целое число: ");
		int a = sc.nextInt();
		sc.close();
		
		int sum = 0;
		
		for (int i = 1; i <= a; i++) {
			sum = sum + i;			
		}		
		
		System.out.println("Сумма чисел от 1 до " + a + " равна: \n" + sum);

	}
}

/*2. Найти max{min(a, b), min(c, d)}. */

package com.epam.training.step01;

import java.lang.Math;

public class Task2_2 {
	public static void main(String[] args) {
		
		double a = 1;
		double b = 2;
		double c = 3;
		double d = 4;
		
		System.out.println(Math.max(Math.min(a, b), Math.min(c, d)));
		
	}
}

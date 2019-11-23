/*Вычислить значение выражения по формуле (все переменные принимают действительные значения):*/

package com.epam.training.step01;

import java.lang.Math;

public class Task1_2 {

	public static void main(String[] args) {
		
		double a = 3.26;
		double b = -94;		
		double c = -9;
		
		System.out.println((b + Math.sqrt(b * b + 4 * a * c)) / 2 * a);

	}

}

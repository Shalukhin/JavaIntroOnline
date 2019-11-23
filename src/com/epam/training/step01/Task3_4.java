/*4. Составить программу нахождения произведения квадратов первых двухсот чисел.*/

package com.epam.training.step01;

import java.math.BigInteger;

public class Task3_4 {

	public static void main(String[] args) {		
		
		BigInteger mult = new BigInteger("1");
		
		for (int i = 1; i <= 200; i++) {
			mult = mult.multiply(new BigInteger(Integer.toString(i))).multiply(new BigInteger(Integer.toString(i)));			
		}
		
		System.out.println(mult);
	}
}
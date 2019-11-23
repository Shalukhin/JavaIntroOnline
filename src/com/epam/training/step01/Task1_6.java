/*6. Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у) 
принадлежит закрашенной области, и false — в противном случае: */

package com.epam.training.step01;

public class Task1_6 {
	
	public static void main(String[] args) {
		
		double x = -10;
		double y = 11;
		
		boolean answer = (y > 4 || y < -3) ? false : ( ((y > 0 && x < -2) || (y > 0 && x > 2)) ? false : ( ((y <= 0 && x < -4) || (y <= 0 && x > 4)) ? false : true ) );
		
		System.out.println(answer);
	
//		if (y > 4 || y < -3) {
//			System.out.println("false");
//			return;
//		}
//		if ((y > 0 && x < -2) || (y > 0 && x > 2)) {
//			System.out.println("false");
//			return;
//		}
//		if ((y <= 0 && x < -4) || (y <= 0 && x > 4)) {
//			System.out.println("false");
//			return;
//		}
//		System.out.println("true");
	}
}

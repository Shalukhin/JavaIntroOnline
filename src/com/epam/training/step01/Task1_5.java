/*5.  Дано  натуральное  число  Т,  которое  представляет  длительность  прошедшего  времени  в  секундах.  Вывести 
данное значение длительности в часах, минутах и секундах в следующей форме: 
ННч ММмин SSc.*/

package com.epam.training.step01;

public class Task1_5 {

	public static void main(String[] args) {
		
		int ss = 9999;
		
 		int h, m, s;
 		
 		h = ss / 3600;
 		m = (ss%3600)/60;
 		s = (ss%3600) % 60;
 		
 		System.out.println(h + "� "+ m + "� " + s + "� ");

	}

}

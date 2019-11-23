/*6. Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.*/

package com.epam.training.step01;

public class Task3_6 {

	public static void main(String[] args) {
		
		char ch = 0;
		
		for (int i = 0; i <= 1120; i++) {					//может быть 65535 значений, т.к. тип char занимает 2 байта
			System.out.println((int)ch + "   " + ch);
			ch++;
		}
	}
}

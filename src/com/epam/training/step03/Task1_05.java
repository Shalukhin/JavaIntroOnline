/*5.  Удалить  в  строке  все  лишние  пробелы,  то  есть  серии  подряд  идущих  пробелов  заменить  на  одиночные  пробелы. 
Крайние пробелы в строке удалить.*/

package com.epam.training.step03;

public class Task1_05 {

	public static void main(String[] args) {
		
		String s = " Всем  привет    и всем   пока!!!  ";
		
		System.out.printf("Исходная строка:\t\t\"%s\"\nОтредактированная строка:\t\"%s\"", s, deleteSpace(s));

	}
	
	public static String deleteSpace (String s) {
		s = s.trim();
		int temp;
		do {
			temp = s.length();
			s = s.replace("  ", " ");
		}
		while (temp != s.length());
		return s;
	}

}

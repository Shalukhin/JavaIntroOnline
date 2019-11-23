/*4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”. */

package com.epam.training.step03;

public class Task2_04 {

	public static void main(String[] args) {
		
		String s = "информатика";
		
		String result = s.substring(7, 8).concat(s.substring(3, 5)).concat(s.substring(7, 8));
		
		System.out.printf("Исходное слово: %s\n\nИскомое слово: %s", s, result);		
	}

}

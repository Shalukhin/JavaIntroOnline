/*7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde 
def", то должно быть выведено "abcdef". */

package com.epam.training.step03;

public class Task2_07 {

	public static void main(String[] args) {
		
		String s = " abc cde def  ";
		
		System.out.printf("Исходная строка:\n\"%s\"\n\nОтредактированная строка:\n\"%s\"", s, delSpacesAndRepeats(s));

	}
	
	public static String delSpacesAndRepeats (String s) {
		
		s = s.trim().replaceAll(" ", "");
		
		StringBuilder sb = new StringBuilder(String.valueOf(s.charAt(0)));
		
		for (int i = 1; i < s.length(); i++) {
			
			boolean flag_add = true;
			for (int j = 0; j < sb.length(); j++) {
				
				if (s.charAt(i) == sb.charAt(j)) {
					flag_add = false;
					break;					
				}
			}
			if (flag_add) {
				sb.append(s.charAt(i));
			}			
		}
		
		return sb.toString();
	}

}

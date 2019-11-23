/* 4. В строке найти количество чисел. */

package com.epam.training.step03;

import java.util.Arrays;

public class Task1_04 {

	public static void main(String[] args) {
		
		String s = "ppp5 ld 5550, g768l0,000 ojlk1";
		
		String[] num = getNumbersFromStr(s);
		
		System.out.printf("В строке \"%s\" присутствуют %d чисел:\n%s", s, num.length, Arrays.toString(num));

	}	
	

	public static String[] getNumbersFromStr (String s) {
		
		String[] mas = new String[0];
					
		boolean flag_start = false;		//флаг нахождения начальной позиции числа
		boolean flag_stop = false;		//флаг нахождения конечной позиции числа
		int start = 0;
		int stop = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			if ((s.charAt(i) == '0') && !flag_start) {
				mas = Arrays.copyOf(mas, mas.length + 1);
				mas[mas.length - 1] = s.substring(i, i + 1);
				continue;
			}
			
			if (Character.isDigit(s.charAt(i)) && !flag_start) {
				start = i;
				flag_start = true;				
			}
			
			if ((i != s.length() - 1) && !Character.isDigit(s.charAt(i + 1)) && flag_start) {
				stop = i;
				flag_stop = true;
				
			}
			
			if ((i == s.length() - 1) && flag_start) {
				stop = i;
				flag_stop = true;				
			}
			
			if (flag_start && flag_stop) {
				mas = Arrays.copyOf(mas, mas.length + 1);
				mas[mas.length - 1] = s.substring(start, stop + 1);
				flag_start = false;
				flag_stop = false;
			}
		}
		return mas;
	}

}

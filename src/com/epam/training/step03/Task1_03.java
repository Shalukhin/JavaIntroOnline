/*3. В строке найти количество цифр.*/

package com.epam.training.step03;

public class Task1_03 {

	public static void main(String[] args) {
		
		String s = "fh bfjk 3j 4j5j666j3fjkd00";
		
		System.out.format("В строке \"%s\" содержится %d цифр", s, howManyNumbersInStr(s));
		

	}
	
	public static int howManyNumbersInStr (String s) {
		
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				count++;
			}
		}
		return count;
	}

}

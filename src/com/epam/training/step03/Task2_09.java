/*9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские 
буквы.*/

package com.epam.training.step03;

public class Task2_09 {

	public static void main(String[] args) {
		
		String s = "EPAM - it is cool, Епам - это круто!";
		
		System.out.printf("В строке: \n\"%s\"\n\nсодержится %d строчных английских букв "
				+ "и %d прописных английских букв.", s, countLowerCaseEnglishSymb(s), countUpperCaseEnglishSymb(s));
	}
	
	public static int countLowerCaseEnglishSymb (String s) {
		
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (String.valueOf(s.charAt(i)).matches("[a-z]")) {
				count++;
			}
		}
		return count;
	}
	
	
	public static int countUpperCaseEnglishSymb (String s) {
		
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (String.valueOf(s.charAt(i)).matches("[A-Z]")) {
				count++;
			}
		}
		return count;
	}

}

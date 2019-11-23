/*3. Проверить, является ли заданное слово палиндромом.*/

package step03;

import java.util.Scanner;

public class Task2_03 {

	public static void main(String[] args) {
		
		String s = getStrFromConsol();
		
		if (isPalindrom(s)) {
			System.out.println("Введённое слово является палиндромом");
		}
		else {
			System.out.println("Введённое слово не является палиндромом");
		}		
		
	}
	
	public static String getStrFromConsol() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите слово:");
		return sc.nextLine();
	}
	
	public static boolean isPalindrom (String s) {
		
		for (int i = 0; i < s.length() / 2; i++ ) {
			
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}

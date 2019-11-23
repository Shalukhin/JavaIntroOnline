/*1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.*/

package step03;

public class Task2_01 {

	public static void main(String[] args) {
		
		String s = " Всем  привет    и всем   пока!!!     ";
		
		System.out.printf("В строке:\n\n\"%s\"\n\nмаксимальное количество подряд идущих пробелов равно %d", s,  maxSpace(s));

	}
	
	public static int maxSpace (String s) {
		
		int max = 0;
		int count = 0;
		boolean flag_start = false;
		boolean flag_stop = false;
		
		for (int i = 0; i < s.length(); i++) {
			
			if ((s.charAt(i) == ' ') && !flag_start) {
				flag_start = true;
			}
			
			if ((s.charAt(i) == ' ') && flag_start) {
				count++;
			}
			
			if ((i != s.length() - 1) && (s.charAt(i + 1) != ' ') && flag_start) {
				flag_stop = true;
			}
			
			if ((i == s.length() - 1) && (s.charAt(i) == ' ') && flag_start) {
				flag_stop = true;
			}
			
			if (flag_start && flag_stop) {
				
				if (max < count) {
					max = count;
				}
				
				count = 0;
				flag_start = false;
				flag_stop = false;
			}			
		}
		return max;
	}

}

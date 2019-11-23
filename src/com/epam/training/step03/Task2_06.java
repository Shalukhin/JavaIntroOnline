/*6. Из заданной строки получить новую, повторив каждый символ дважды.*/

package step03;

public class Task2_06 {

	public static void main(String[] args) {
		
		String s = "Из заданной строки получить новую, повторив каждый символ дважды.";
		
		System.out.printf("Исходная строка:\n\"%s\"\n\nОтредактированная строка:\n\"%s\"", s, repeatSymb(s));		

	}
	
	public static String repeatSymb (String s) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char symb = s.charAt(i);
			sb.append(symb);
			sb.append(symb);
		}
		return sb.toString();
	}

}

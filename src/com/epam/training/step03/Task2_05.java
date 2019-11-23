/*5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”. */

package step03;

public class Task2_05 {

	public static void main(String[] args) {
		
		String s = "Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.";
		
		char sym = 'а';
		
		System.out.printf("В строке: \n\n\"%s\"\n\nсимвол \'%c\' встречается %d раз", s, sym, getCountSymbol(s, sym));
		
	}
	
	public static int getCountSymbol (String s, char symbol) {
		
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == symbol) {
				count++;
			}
		}
		return count;
	}

}

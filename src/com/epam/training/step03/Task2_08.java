/*8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых 
длинных слов может быть несколько, не обрабатывать. */

package step03;

public class Task2_08 {

	public static void main(String[] args) {
		
		String s = "Вводится строка слов разделенных пробелами Найти самое длинное слово и вывести его на экран "
				+ "\nСлучай когда самых длинных слов может быть несколько не обрабатывать";
		
		System.out.printf("Исходный текст:\n\"%s\"\n\nСамое длинное слово в тексте:  \"%s\"", s, findBigWord(s));

	}
	
	public static String findBigWord (String s) {
		
		String[] mas = s.split(" ");
		
		int max = 0;
		int max_id = 0;
		
		for (int i = 0; i < mas.length; i++) {
			if (max < mas[i].length()) {
				max = mas[i].length();
				max_id = i;
			}
		}
		
		return mas[max_id];
	}

}

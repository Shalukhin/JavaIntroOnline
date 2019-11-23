/*10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным 
знаком. Определить количество предложений в строке X. */

package step03;

public class Task2_10 {

	public static void main(String[] args) {
		
		String s = "Привет! Как у тебя дела? Когда начинается тренинг в епаме? По-моему, в сентябре.";
		
		System.out.printf("Текст: \n\n\"%s\"\n\nсостоит из %d предложений.", s, countTopic(s));

	}
	
	public static int countTopic (String s) {
		
		String[] mas = s.split("\\!|\\?|\\.");
		
		return mas.length;
	}

}

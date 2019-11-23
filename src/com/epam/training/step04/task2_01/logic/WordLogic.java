package step04.task2_01.logic;

import step04.task2_01.beans.Word;

public class WordLogic {
	
	public WordLogic() {
		super();
	}

	public void addSymb (Word word, char ch) {
		if (ch == ' ') {
			System.out.println("Слово не должно содержать пробелов");
		} else {
			word.setTxtWord(word.getTxtWord() + ch);
		}		
	}
}

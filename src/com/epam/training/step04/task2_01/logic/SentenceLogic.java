package com.epam.training.step04.task2_01.logic;

import com.epam.training.step04.task2_01.beans.Sentence;
import com.epam.training.step04.task2_01.beans.Word;

public class SentenceLogic {
	
	public SentenceLogic() {
		super();
	}

	public void addWord(Sentence sentence, Word word) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (sentence.getTxtSent().charAt(sentence.getTxtSent().length() - 1 - i) == '.' || 
			   sentence.getTxtSent().charAt(sentence.getTxtSent().length() - 1 - i) == '!' || 
			   sentence.getTxtSent().charAt(sentence.getTxtSent().length() - 1 - i) == '?')     {
			i++;
		}
		sb.append(sentence.getTxtSent().substring(0, sentence.getTxtSent().length() - i));
		sb.append(" ");
		sb.append(word.getTxtWord().toLowerCase());
		if (!(sb.charAt(sb.length() - 1) == '.' || sb.charAt(sb.length() - 1) == '!' || sb.charAt(sb.length() - 1) == '?') ) {
			sb.append(".");
		}
		sentence.setTxtSent(sb.toString());
	}	

}

package com.epam.training.step04.task2_01.logic;

import com.epam.training.step04.task2_01.beans.Sentence;
import com.epam.training.step04.task2_01.beans.Text;
import com.epam.training.step04.task2_01.beans.Word;

public class TextLogic {

	public TextLogic() {
		super();
	}
	
	public void addSentence (Text text, Sentence sentence) {
		add(text, sentence.getTxtSent());
	}
	
	public void addWord (Text text, Word word) {
		add(text, word.getTxtWord());
	}
	
	private void add(Text text, String str) {
		StringBuilder sb = new StringBuilder(text.getTxtText());
		if (sb.length() != 0) {
			sb.append(" ");
		}		
		sb.append(str);
		text.setTxtText(sb.toString());
	}
	
	public String allText(Text text) {
		return String.format("----------------------------\n\t\t%s\n\n%s\n----------------------------", text.getTitle(), text.getTxtText());
		
	}
}

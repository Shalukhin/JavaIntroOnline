/*1. Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на 
консоль текст, заголовок текста.*/

package step04.task2_01.main;

import step04.task2_01.beans.Sentence;
import step04.task2_01.beans.Text;
import step04.task2_01.beans.Word;
import step04.task2_01.logic.SentenceLogic;
import step04.task2_01.logic.TextLogic;
import step04.task2_01.logic.WordLogic;

public class Runner {

	public static void main(String[] args) {
		
		TextLogic textLogic = new TextLogic();
		SentenceLogic sentenceLogic = new SentenceLogic();
		WordLogic wordLogic = new WordLogic();
		
		
		Word word = new Word("Привет");		
		
		System.out.println(word.getTxtWord());
		
		wordLogic.addSymb(word, '!');
		
		System.out.println(word.getTxtWord());
		
		Sentence sentence = new Sentence("Хочу на курсы!");
		
		System.out.println(sentence.getTxtSent());
		
		sentenceLogic.addWord(sentence, new Word("java"));
		
		System.out.println(sentence.getTxtSent());
		
		sentenceLogic.addWord(sentence, new Word("development!"));
		
		System.out.println(sentence.getTxtSent());
		
		Text text = new Text(word);		
		
		textLogic.addSentence(text, sentence);
		textLogic.addWord(text, new Word("Очень-очень!"));
		
		System.out.println(textLogic.allText(text));
	}
}

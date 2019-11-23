/*1.  Cоздать  приложение,  разбирающее  текст  (текст  хранится  в  строке)  и  позволяющее  выполнять  
с  текстом  три  различных операции:  отсортировать  абзацы  по  количеству  предложений;  в  каждом  
предложении  отсортировать  слова  по  длине; отсортировать лексемы в предложении по убыванию 
количества вхождений заданного символа, а в случае равенства – по алфавиту. */

package step03;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3_01 {

	public static void main(String[] args) {
		
		String command;
		
		do {
			System.out.println("Введите \"1\" чтобы отсортировать  абзацы  по  количеству  предложений");
			System.out.println("Введите \"2\" чтобы в  каждом  предложении  отсортировать  слова  по  длине");
			System.out.println("Введите \"3\" чтобы отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту");
			System.out.println("Введите \"p\" чтобы напечатать исходный текст");
			System.out.println("Введите \"q\" чтобы завершить программу");
			
			command = getStrFromCons();
			
			switch (command) {
			
			case "1" : {
				System.out.println(sortParagraphs(text));
				
				break;				
			}
			
			case "2" : {
				
				String[] sentences = sortSentences(text);
				for (String sent : sentences) {
					System.out.println("[" + sent + "]");
				}
				System.out.println();
				
				break;
			}
			
			case "3" : {
				
				System.out.println("Введите символ:");
				char ch = getCharFromCons();
				
				String[] sentences = sortSentencesBySymb(text, ch);
				for (String sent : sentences) {
					System.out.println("[" + sent + "]");
				}
				System.out.println();
				
				break;				
			}
			
			case "p" : {
				System.out.println(text);
				System.out.println();
				
			}
			}
			
		} while (!command.equals("q"));		
		
	}
	
	public static char getCharFromCons() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNext()) {
			System.out.println("Введите значение");
		}
		return sc.next().charAt(0);
	}
	
	public static String getStrFromCons() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextLine()) {
			System.out.println("Введите значение");
		}
		return sc.nextLine();
	}
	
	public static String sortParagraphs (String s) {
		
		String[] parag = s.trim().split("\\n\\t");
		
		int i = 0;
		
		while (i < parag.length - 1) {
			
			if (parag[i].split("\\.\\s|\\!|\\?").length > parag[i + 1].split("\\.\\s|\\!|\\?").length) {
				String temp = parag[i];
				parag[i] = parag[i + 1];
				parag[i + 1] = temp;
				
				if (i != 0) {
					i--;
				}
			}
			else {
				i++;
			}		
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int j = 0; j < parag.length; j++) {
			
			sb.append("\t");
			sb.append(parag[j].trim());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public static String[] sortSentences (String s) {
		StringBuilder sb = new StringBuilder(s);
		Pattern pat = Pattern.compile("\n");
		Matcher mat = pat.matcher(sb);
		while (mat.find()) {						//1.Избавляемся в тексте от переходов на новую строку
			
			sb.replace(mat.start(), mat.start() + 1, "");
			mat.reset();
		}
		//String[] sentences = sb.toString().split("\\.\\s|\\!|\\?");
		pat = Pattern.compile("\\.\\s[А-ЯЁ]|\\!|\\?");
		mat = pat.matcher(sb);
		String[] sentences = new String[0];
		int position = 0;
		
		while (mat.find()) {								//2.Разбиваем текст на массив предложений
			
			String temp = sb.substring(position, mat.start());
			sentences = Arrays.copyOf(sentences, sentences.length + 1);
			sentences[sentences.length - 1] = temp;
			position = mat.end() - 1;
						
		}
		
		sentences = Arrays.copyOf(sentences, sentences.length + 1);
		sentences[sentences.length - 1] = sb.substring(position, sb.length() - 1);
		
		String[][] sent_word = new String[sentences.length][];				//3.Создаём массив массивов слов полученных от разбиения предложений на слова
		for (int i = 0; i < sent_word.length; i++) {
			sent_word[i] = sentences[i].trim().replaceAll(",", "").split(" ");
			int j = 0;
			while (j < sent_word[i].length - 1) {
				if (sent_word[i][j].length() > sent_word[i][j + 1].length()) {		//4.Сортируем слова в порядке возростания кол-ва букв в перделах каждого массива
					String temp = sent_word[i][j];
					sent_word[i][j] = sent_word[i][j + 1];
					sent_word[i][j + 1] = temp;
					
					if (j != 0) {
						j--;
					}
				}
				else {
					j++;
				}
			
			}
			StringBuilder sent_sort = new StringBuilder(sent_word[i][0]);		//5.Собираем строки предложений из отсортированных массивов слов
			for (int k = 1; k < sent_word[i].length; k++) {
				sent_sort.append(" ");
				sent_sort.append(sent_word[i][k]);
			}
			sentences[i] = sent_sort.toString();
		}
		
				
		return sentences;
	}
	
	public static String[] sortSentencesBySymb (String s, char ch) {
		StringBuilder sb = new StringBuilder(s);
		Pattern pat = Pattern.compile("\n");
		Matcher mat = pat.matcher(sb);
		while (mat.find()) {						//1.Избавляемся в тексте от переходов на новую строку
			
			sb.replace(mat.start(), mat.start() + 1, "");
			mat.reset();
		}
		//String[] sentences = sb.toString().split("\\.\\s|\\!|\\?");
		pat = Pattern.compile("\\.\\s[А-ЯЁ]|\\!|\\?");
		mat = pat.matcher(sb);
		String[] sentences = new String[0];
		int position = 0;
		
		while (mat.find()) {								//2.Разбиваем текст на массив предложений
			
			String temp = sb.substring(position, mat.start());
			sentences = Arrays.copyOf(sentences, sentences.length + 1);
			sentences[sentences.length - 1] = temp;
			position = mat.end() - 1;
						
		}
		
		sentences = Arrays.copyOf(sentences, sentences.length + 1);
		sentences[sentences.length - 1] = sb.substring(position, sb.length() - 1);
		
		String[][] sent_word = new String[sentences.length][];				//3.Создаём массив массивов слов полученных от разбиения предложений на слова
		for (int i = 0; i < sent_word.length; i++) {
			sent_word[i] = sentences[i].trim().replaceAll(",", "").split(" ");
			int j = 0;
			while (j < sent_word[i].length - 1) {
				
				if (countSymbInLexem(sent_word[i][j], ch) > countSymbInLexem(sent_word[i][j + 1], ch)) {		//4.Сортируем слова в порядке возростания кол-ва букв в перделах каждого массива
					String temp = sent_word[i][j];
					sent_word[i][j] = sent_word[i][j + 1];
					sent_word[i][j + 1] = temp;
					
					if (j != 0) {
						j--;
					} 
				}
				else if (countSymbInLexem(sent_word[i][j], ch) == countSymbInLexem(sent_word[i][j + 1], ch)) {
					
					if(sent_word[i][j].compareTo(sent_word[i][j + 1]) > 0) {
						String temp = sent_word[i][j];
						sent_word[i][j] = sent_word[i][j + 1];
						sent_word[i][j + 1] = temp;
						
						if (j != 0) {
							j--;
						}
					}
					else {
						j++;
					}
				}
				else {
					j++;
				}
			
			}
			StringBuilder sent_sort = new StringBuilder(sent_word[i][0]);		//5.Собираем строки предложений из отсортированных массивов слов
			for (int k = 1; k < sent_word[i].length; k++) {
				sent_sort.append(" ");
				sent_sort.append(sent_word[i][k]);
			}
			sentences[i] = sent_sort.toString();
		}
		
				
		return sentences;
	}
	
	public static int countSymbInLexem (String s, char ch) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}
	
	public static final String text = 
			"\tПредставим себе, что можно найти “центры тяжести” отрицательных и положительных частей молекулы. \n"
			+ "Тогда условно все вещества можно разбить на две группы. Одну группу составляют те, в молекулах которых \n"
			+ "оба “центра тяжести” совпадают. Такие молекулы называются неполярными. К ним относятся все ковалентные \n"
			+ "двухатомные молекулы вида А2, а также молекулы, состоящие из трех и более атомов, имеющие высокосимметричное \n"
			+ "строение, например СО2, СS2, СCl4, С6 H6. Во вторую группу входят все вещества, у которых “центры тяжести” \n"
			+ "зарядов в молекуле не совпадают, молекулы которых характеризуются электрической асимметрией. Эти молекулы \n"
			+ "называют полярными. К ним относятся молекулы вида АВ, в которых элементы А и В имеют различную электроотрицательность, \n"
			+ "и многие более сложные молекулы. Систему из двух разноименных электрических зарядов, равных по абсолютной величине, \n"
			+ "называют диполем.\n" + 
			"\tПолярность молекулы (и полярность связи) характеризуется дипольным моментом молекулы (или связи). Величина дипольного \n"
			+ "момента сильно влияет на свойства полярных молекул и веществ, построенных из таких молекул. Полярные молекулы поляризуются \n"
			+ "в электрическом поле, устанавливаясь по силовым линиям поля, ориентируются в электических полях, создаваемых ионами в \n"
			+ "растворах, взаимодействуют между собой, замыкая свои электрические поля. Дипольный момент образуется за счет смещения \n"
			+ "центров положительного и отрицательного зарядов на некоторую величину l, называемую длиной диполя. Чем более полярны \n"
			+ "молекулы, чем значительнее смещены валентные электронные пары к одному из атомов, тем больше дипольный момент. \n"
			+ "И наоборот, если электрическая ассиметрия молекул незначительна, то величина дипольного момента невлика.\n" + 
			"\tДля системы из двух частиц дипольный момент равен: e*l, где e- величина заряда;l- расстояние между центрами. \n"
			+ "Однако, определяя сразу величину дипольного момента, мы не знаем ни величины заряда e, локализованного в полярной \n"
			+ "молекуле, ни расстояния между центрами l. Принимаем e равным заряду электрона(1,6021*10-19Кл) и тогда получаем \n"
			+ "приведенную длину диполя l, которая  является условной величиной. В качестве единицы измерения дипольных моментов \n"
			+ "принят дебай (названный в честь голландского физика П.Дебая, разработавшего теорию полярных молекул). \n"
			+ "В системе СИ 1D=0,33*10-29Кл*м. Дипольные моменты обычно определяют экспериментально, измеряя относительную \n"
			+ "диэлектрическую проницаемость веществ при различных температурах. Если вещество поместить в электрическое поле, \n"
			+ "создаваемое конденсатором, то емкость последнего возрастет в e раз, т.е. e=c/c0 (где c0 и с- емкость конденсатора \n"
			+ "в вакууме и в среде вещества).";

}

/*2. Замените в строке все вхождения 'word' на 'letter'. */

package step03;

public class Task1_02 {

	public static void main(String[] args) {

		String s = "word is good! word wword woord words";
		
		//System.out.println(s.replaceAll("word", "letter"));
		
		System.out.println(changeText(s));
		

	}
	
	public static String changeText (String s) {
		
		for (int i = 0; i < s.length(); i++) {
			
			if ((s.charAt(i) == 'w') && (s.charAt(i + 1) == 'o') && (s.charAt(i + 2) == 'r') && (s.charAt(i + 3) == 'd')){
				s = s.substring(0, i) + "letter" + s.substring(i + 4);
				i = i + 5;
			}
		}
		return s;
	}

}

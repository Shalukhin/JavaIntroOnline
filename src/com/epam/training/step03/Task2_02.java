/* 2. В строке вставить после каждого символа 'a' символ 'b'. */

package step03;

public class Task2_02 {

	public static void main(String[] args) {
		
		String s = "a a v g e a y aa gag";
		
		System.out.printf("Исходная строка: \n\"%s\"", s);
		
		System.out.printf("\n\nОтредактированная строка: \n\"%s\"", s.replaceAll("a", "ab"));
		
	}	

}

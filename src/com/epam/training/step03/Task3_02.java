/*Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа 
 * и его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела). 
 * Пользоваться готовыми парсерами XML для решения данной задачи нельзя. */

package step03;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3_02 {

	public static String doc = "<notes> \r\n" + "   <note id = \"1\"> \r\n" + "       <to>Вася</to> \r\n"
			+ "       <from>Света</from> \r\n" + "       <heading>Напоминание</heading> \r\n"
			+ "       <body>Позвони мне завтра!</body> \r\n" + "   </note> \r\n" + "   <note id = \"2\"> \r\n"
			+ "       <to>Петя</to> \r\n" + "       <from>Маша</from> \r\n"
			+ "       <heading>Важное напоминание</heading> \r\n" + "       <body/> \r\n" + "   </note> \r\n"
			+ "</notes> ";

	public static void main(String[] args) {

		String[] arr = decomposite(doc);
		String command;
		int count = 0;
		System.out.println(arr[count]);
		
		do {
			System.out.println("Для отображения следующего узла введите \"n\"");
			System.out.println("Для отображения предыдущего узла введите \"b\"");
			System.out.println("Для отображения всех узлов введите \"a\"");
			System.out.println("Для заверешения приложения введите \"q\"");
			
			command = getStrFromCons();
			
			switch (command) {
			case "n": {
				count++;
				int ind = Math.abs(count) % arr.length;
				System.out.println(arr[ind]);

				break;
			}
			case "b": {
				count--;
				int ind = Math.abs(count) % arr.length;
				System.out.println(arr[ind]);

				break;
			}
			case "a": {
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
					System.out.println("--------------------------");
				}
				count = 0;

				break;
			}
			}

		} while (!command.equals("q"));		
	}

	public static String getStrFromCons() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextLine()) {
			System.out.println("Введите значение");
		}
		return sc.nextLine();
	}

	public static String[] decomposite(String s) {
		
		String[] tags = new String[0];
		Pattern pat = Pattern.compile("<[^/].+?>");
		Matcher mat = pat.matcher(s);
		
		while (mat.find()) {
			StringBuilder sb = new StringBuilder(mat.group());
			if (mat.group().matches(".+/.*")) {
				tags = Arrays.copyOf(tags, tags.length + 1);
				tags[tags.length - 1] = sb.toString();
				break;
			}
			String part = s.substring(mat.end());
			Pattern pat_end = Pattern
					.compile("</" + mat.group().substring(1, mat.group().length() - 1).split(" ")[0] + ">");
			Matcher mat_end = pat_end.matcher(part);
			if (mat_end.find()) {
				sb.append("\n");
				sb.append(part.substring(0, mat_end.start()));
				sb.append("\n");
				sb.append(mat_end.group());
			} else {
				sb.append("Этот тэг повреждён!");
			}
			
			tags = Arrays.copyOf(tags, tags.length + 1);
			tags[tags.length - 1] = sb.toString();

		}
		
		return tags;

	}

}

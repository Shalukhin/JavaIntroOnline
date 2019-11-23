/*1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.*/

package step03;

import java.util.Arrays;

public class Task1_01 {

	public static void main(String[] args) {
		
		String[] camelCase = {"ivanIvanov", "petrPetrov", "maxSidorov"};
		
		String[] snake_case = changeMassiv(camelCase);
		
		System.out.format("Массив названий в camelCase:\n%s\n", Arrays.toString(camelCase));
		System.out.format("\nМассив названий в snake_case:\n%s", Arrays.toString(snake_case));

	}
	
	public static String[] changeMassiv (String[] arr) {
		
		String[] temp = Arrays.copyOf(arr, arr.length);
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = convert(temp[i]);
		}
		
		return temp;		
	}
	
	
	public static String convert (String s) {
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				s = s.replace(String.valueOf(s.charAt(i)), "_"+String.valueOf(Character.toLowerCase(s.charAt(i))));
			}
		}
		
		return s;
	}

}

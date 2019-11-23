/*4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами 
дробную и целую части числа и вывести полученное значение числа.*/

package step01;

public class Task1_4 {

	public static void main(String[] args) {
		
		double d = 123.456;		

		double res = d * 1000 % 1000 + (double)((int)d) / 1000;
		
		System.out.println(res);

	}

}

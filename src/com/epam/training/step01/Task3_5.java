/*5.  Даны  числовой  ряд  и  некоторое  число  е.  Найти  сумму  тех  членов  ряда,  модуль  которых  больше  или  равен 
заданному е. Общий член ряда имеет вид:*/

package step01;

public class Task3_5 {

	public static void main(String[] args) {
		
		int n = 10;
		double e = 0.00000001;
		double sum = 0;
		
		for (int i = 1; i <= n; i++ ) {
			double a = 1 / Math.pow(2, i) + 1 / Math.pow(3, i);
			if (Math.abs(a) >= e) sum = sum + a;			
		}
		
		System.out.println(sum);
	}
}

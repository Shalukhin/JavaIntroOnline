/* 5. Сортировка вставками. Дана последовательность чисел. Требуется переставить числа в порядке возрастания.  Делается  это  следующим  образом. 
 * Берется  следующее  число и  вставляется  в  последовательность  так,  чтобы  новая последовательность была тоже возрастающей. Процесс производится до тех пор, 
 * пока все элементы от i +1 до n не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить 
с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции. */

package step02;

import java.util.Arrays;

public class Task3_05 {

	public static void main(String[] args) {		

		int[] a = {10, 7, 5, 6, 1, 8, 14, 9, 1};		
		
		System.out.println("Исходный массив:\n" + Arrays.toString(a));		
			
		for (int i = 1; i < a.length; i++) {
			
			int temp = a[i];
			int poz = dihotom(a, i);
			
			for (int j = i; j > poz; j--) {
				a[j] = a[j - 1];
			}
			a[poz] = temp;
			
		}
		
		System.out.println("\nРезультирующий массив:\n" +Arrays.toString(a));
	}
	
	public static int dihotom (int[] a, int k) {
		
		if (a[k - 1] <= a[k]) return k;	
		
		int s = 0;
		int f = k - 1;
		
		while (s != f) {
			
			if (a[(f + s) / 2] < a[k]) {
				s = (f + s) / 2 + 1;							
			}
			else {				
				f = (f + s) / 2;			
			}			
		}
		
		return s;		
	}
}

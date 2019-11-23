/*10.  Дан  целочисленный  массив  с  количеством  элементов  п.  Сжать  массив,  выбросив  из  него  каждый  второй 
элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать. */

package step02;

import java.util.Arrays;

public class Task1_10 {

	public static void main(String[] args) {
		
		int n = 9;
		int[] a = new int[n];		
		
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*100);
		}
		
		System.out.println("Исходый массив:\n" + Arrays.toString(a));
		
		System.out.print("\nТак должен выглядеть массив после преобразований:\n[");	//вывод на консоль того, что должны получить в результате преобразования
		int k = 0;																	
		for (int i = 0; i < a.length; i++) {										
			if ((i+1) % 2 != 0) {													
				System.out.print(a[i]+ ", " );
				k++;
			}
		}
		for (int i = k; i < a.length; i++) {
			if (i != a.length-1) System.out.print("0, ");
			else System.out.println("0]");
		}																			//вывод на консоль того, что должны получить в результате преобразования
		
		
		for (int j = 1; j <= (a.length)/2; j++) {			
			for (int i = j; i < a.length-1; i++) {
				a[i]= a[i + 1];			
			}			
			a[a.length-j] = 0;			
		}
		
		System.out.println("\nМассив после преобразоваия:\n" + Arrays.toString(a));
	}
}

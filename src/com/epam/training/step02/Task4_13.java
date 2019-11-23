/*13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43). 
Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для 
решения задачи использовать декомпозицию. */

package step02;

public class Task4_13 {

	public static void main(String[] args) {
		
		int n = 40;
		
		System.out.printf("Простые числа \"близнецы\" на отрезке от %d до %d:\n", n, 2 * n);
		
		findAndPrintTwinNumb(n);

	}
	
	public static void findAndPrintTwinNumb (int n) {
		
		for (int i = n + 2; i <= 2 * n; i++) {
			
			if (isSimple(i) && isSimple(i - 2)) {
				
				System.out.println(i - 2 + " и " + i);
			}
		}
	}
	
	public static boolean isSimple (int a) {
		for (int i = 2; i <= a / 2; i++ ) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

}

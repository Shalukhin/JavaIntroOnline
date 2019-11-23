/*8.Даны дроби. Составить программу, которая приводит эти дроби к общему 
знаменателю и упорядочивает их в порядке возрастания. */

package step02;

import java.util.Formatter;
import java.util.Locale;

public class Task3_08 {

	public static void main(String[] args) {
						
		int[] p = {1, 2, 4,  8, 11, 38, 1};
		int[] q = {2, 5, 7, 11, 17, 55, 60};
		
		int[][] fraction = {p, q};
		
		System.out.println("Исходные дроби:\n");
		drowFractions(fraction);
		
		int nok = getNokForMassiv(fraction[1]);		
		
		for (int i = 0; i < fraction[0].length; i++) {
			fraction[0][i] = fraction[0][i] * nok / fraction[1][i]; 
			fraction[1][i] = nok;
		}
		
		System.out.println();
		System.out.println("Дроби, приведённые к общему знаменателю:\n");
		drowFractions(fraction);
		
		int i = 1;
		while (i != fraction[0].length) {
			if (i == 0) {
				i++;
			}
			if (fraction[0][i - 1] > fraction[0][i]) {
				int temp = fraction[0][i - 1];
				fraction[0][i - 1] = fraction[0][i];
				fraction[0][i] = temp;
				i--;
			}
			else {
				i++;
			}
		}
		
		System.out.println();
		System.out.println("Дроби, расставленные в порядке возрастания:\n");
		drowFractions(fraction);
	}
	
	public static int getNokForMassiv (int[] a) {
		
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (max < a[i]) max = a[i];
		}
		
		while (true) {
			int ost = 0;
			for (int i = 0; i < a.length; i++) {
				ost = ost + max % a[i];
			}
			if (ost == 0) {
				return max;
			}
			max++;			
		}
	}
	
	public static void drowFractions (int[][] f) {
		int[] num_str = new int[f[0].length];
		for (int i = 0; i < f[0].length; i++) {
			num_str[i] = Math.max(Integer.toString(f[0][i]).length(), Integer.toString(f[1][i]).length());
		}
		Formatter formatter1 = new Formatter(Locale.US);
		Formatter formatter2 = new Formatter(Locale.US);
		Formatter formatter3 = new Formatter(Locale.US);
		
		for (int i = 0; i < f[0].length; i++) {
			for (int j = 1; j <= num_str[i] - Integer.toString(f[0][i]).length()+1; j++) {
				formatter1.format(" ");				
			}			
			formatter1.format("%d   ",f[0][i]);
			
			for (int j = 1; j <= num_str[i]+1; j++) {
				formatter2.format("-");
			}
			formatter2.format("-; ");
			
			for (int j = 1; j <= num_str[i] - Integer.toString(f[1][i]).length()+1; j++) {
				formatter3.format(" ");				
			}			
			formatter3.format("%d   ",f[1][i]);			
		}
		
		System.out.println(formatter1);
		System.out.println(formatter2);
		System.out.println(formatter3);
	}
}

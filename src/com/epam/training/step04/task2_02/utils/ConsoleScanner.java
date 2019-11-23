package com.epam.training.step04.task2_02.utils;

import java.util.Scanner;

public class ConsoleScanner {
	
	public String getStrFromConsol() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	
	public int getIntFromConsol() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);		
		while (!sc.hasNextInt()) {
			System.out.println("введите число!");
			sc.next();			
		}		
		return sc.nextInt();
	}
	
	
	public double getDoubleFromConsol() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);		
		while (!sc.hasNextDouble()) {
			System.out.println("введите число!");
			sc.next();			
		}		
		return sc.nextDouble();
	}

}

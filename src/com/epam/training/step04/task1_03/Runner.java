/*3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив 
из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и 
номеров групп студентов, имеющих оценки, равные только 9 или 10. */

package com.epam.training.step04.task1_03;

public class Runner {

	public static void main(String[] args) {
		
		Student[] students = new Student[10];
		
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student();
			students[i].setName("ФИО_" + (i + 1));
			students[i].setNumbGroup((int)(Math.random() * 5) + 1);
			for (int j = 0; j < students[i].balls.length; j++) {
				students[i].balls[j] = (int)(Math.random() * 11);
			}			
		}
		
		int[] high_ball = {9, 9, 10, 9, 9};
		
		students[4].setBalls(high_ball);
		students[9].setBalls(high_ball);
		
		System.out.println("Студенты имеющие оценки только 9 и 10:\n");
		
		for (int i = 0; i < students.length; i++) {
			boolean is_high = true;
			for (int j = 0; j < students[i].balls.length; j++) {
				if (students[i].balls[j] < 9) {
					is_high = false;
					break;
				}				
			}
			if (is_high) {
				System.out.println(students[i]);
			}
		}		
	}
}

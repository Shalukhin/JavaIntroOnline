/*3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив 
из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и 
номеров групп студентов, имеющих оценки, равные только 9 или 10. */

package step04.task1_03;

import java.util.Arrays;

public class Student {

	public String name;
	public int numbGroup;
	public int[] balls = new int[5];
	
	
	
	public Student() {
		super();		
	}

	public Student(String name, int numbGroup, int[] balls) {
		super();
		this.name = name;
		this.numbGroup = numbGroup;
		this.balls = balls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumbGroup() {
		return numbGroup;
	}

	public void setNumbGroup(int numbGroup) {
		this.numbGroup = numbGroup;
	}

	public int[] getBalls() {
		return balls;
	}

	public void setBalls(int[] balls) {
		this.balls = balls;
	}

	@Override
	public String toString() {
		return "Student\t name=" + name + "\n\t numbGroup=" + numbGroup + "\n\t balls=" + Arrays.toString(balls);
	}	

}

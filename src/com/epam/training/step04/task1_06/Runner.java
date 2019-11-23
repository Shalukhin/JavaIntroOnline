/*6. Составьте описание класса для представления времени. Предусмотрте возможности установки времени и 
изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае 
недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на 
заданное количество часов, минут и секунд. */

package step04.task1_06;

public class Runner {

	public static void main(String[] args) {

		Time time = new Time();

		System.out.println("---1---\n" + time + "\n-------\n");

		time.setTime("14:45:00");

		System.out.println("---2---\n" + time + "\n-------\n");

		time.setTime("55:77:88");

		System.out.println("---3---\n" + time + "\n-------\n");

		time.setTime("-34:gee:5");

		System.out.println("---4---\n" + time + "\n-------\n");

		time.setTime("17:28");

		System.out.println("---5---\n" + time + "\n-------\n");

		time.setTime("1");

		System.out.println("---6---\n" + time + "\n-------\n");

		time.setMinutes(-35);

		System.out.println("---7---\n" + time + "\n-------\n");

		time.setSeconds(700);

		System.out.println("---8---\n" + time + "\n-------\n");

		time.setHours(-1);

		System.out.println("---9---\n" + time + "\n-------\n");
		
		time.setHours(22);

		System.out.println("---10---\n" + time + "\n--------\n");
		
		time.addSeconds(1);

		System.out.println("---11---\n" + time + "\n--------\n");
		
		time.addSeconds(-5678);

		System.out.println("---12---\n" + time + "\n--------\n");
		
		time.addSeconds(7000000);

		System.out.println("---13---\n" + time + "\n--------\n");
		
		time.addMinutes(-800);

		System.out.println("---14---\n" + time + "\n--------\n");
		
		time.addHours(4);

		System.out.println("---15---\n" + time + "\n--------\n");
		
		time.reset();

		System.out.println("---16---\n" + time + "\n--------\n");

	}
}

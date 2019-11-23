/*5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение 
на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и 
произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод 
позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса. */

package step04.task1_05;

public class Runner {

	public static void main(String[] args) {
		
		Counter counter1 = new Counter();
		Counter counter2 = new Counter(7000, -5000, 6000);
		
		System.out.println("1ый " + counter1);
		System.out.println("2ый " + counter2);
		System.out.println();
		
		while (counter2.decrement()) {
			
			counter1.increment();
		}
		
		System.out.println("1ый " + counter1);
		System.out.println("2ый " + counter2);
		System.out.println();
		
		counter2.setMin(counter1.getCount());
		counter2.setMin(-4000);
		counter2.setMax(counter1.getCount());		
		counter1.setCount(counter2.getMax() / 5);
		
		System.out.println("1ый " + counter1);
		System.out.println("2ый " + counter2);
		System.out.println();
		
	}
}

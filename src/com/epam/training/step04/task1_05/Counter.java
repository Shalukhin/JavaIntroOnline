/*5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение 
на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и 
произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод 
позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса. */

package step04.task1_05;

public class Counter {
	
	private int count;
	private int min;
	private int max;
	
	public Counter() {
		super();
		count = 0;
		min = Integer.MIN_VALUE;
		max = Integer.MAX_VALUE;
	}

		
	public Counter(int start, int min, int max) {
		
		super();
		if (start > max) {
			System.out.println("Введённое значение счётчика больше максимально-возможного. Счётчик установлен на max значение " + max);
			this.count = max;
		} else if (start < min) {
			this.count = min;
			System.out.println("Введённое значение счётчика меньше минимально-возможного. Счётчик установлен на min значение " + min);
		} else {		
			this.count = start;
		}
				
		if (max < min) {
			System.out.println("Диапазон счётчика не корректен (max < min)! Установлен стандартный диапазон!");
			min = Integer.MIN_VALUE;
			max = Integer.MAX_VALUE;
		} else {
			this.min = min;
			this.max = max;
		}
	}


	public int getCount() {
		return count;
	}


	public void setCount(int start) {
		if (start > max) {
			System.out.println("Введённое значение счётчика больше максимально-возможного. Счётчик установлен на max значение " + max);
			this.count = max;
		} else if (start < min) {
			this.count = min;
			System.out.println("Введённое значение счётчика меньше минимально-возможного. Счётчик установлен на min значение " + min);
		} else {
			this.count = start;
		}
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
				
		if (this.max < min) {
			System.out.println("Диапазон счётчика не корректен (max < min)! Значение max не изменено!");
		} else if (this.count < min) {
			System.out.println("Значение счётчика меньше введённого минимума! Значение счётчика установлено в минимальное значение!");
			this.min = min;
			this.count = min;
		} else {
			this.min = min;
		}
	}

		
	public int getMax() {
		return max;
	}

		
	public void setMax(int max) {
				
		if (max < this.min) {
			System.out.println("Диапазон счётчика не корректен (max < min)! Значение min не изменено!");
		
		} else if(this.count > max) {
			System.out.println("Значение счётчика больше введённого максимума! Значение счётчика установлено в максимальное значение!");
			this.max = max;
			this.count = max;
		} else {
			this.max = max;
		}
	}

		
	public boolean increment() {
		if (count < max) {
			count++;
			return true;
		} else {
			System.out.println("Счётчик достиг максимального значения " + max + "!");
			return false;
		}		
	}
	
		
	public boolean decrement() {
		if (count > min) {
			count--;
			return true;
		} else {
			System.out.println("Счётчик достиг минимального значения " + min + "!");
			return false;
		}		
	}
	
		
	@Override
	public String toString() {
		return "Counter [count=" + count + ", min=" + min + ", max=" + max + "]";
	}
}

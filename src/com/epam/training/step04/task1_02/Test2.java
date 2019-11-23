/* 2. Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте 
конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра 
класса.*/

package step04.task1_02;

public class Test2 {
	
	public int a;
	
	public int b;

	public Test2(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Test2() {
		super();
		a = 3;
		b = 5;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("a = ");
		sb.append(a);
		sb.append("\n");
		sb.append("b = ");
		sb.append(b);
		
		return sb.toString();
	}
	
	

}

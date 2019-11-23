/*8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы 
и метод  toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами 
и методами. Задать критерии выбора данных и вывести эти данные на консоль.
Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.  
Найти и вывести:  
a) список покупателей в алфавитном порядке;  
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале */

package step04.task1_08_09_10.task1_08;

import java.util.Arrays;
import step04.task1_08_09_10.AgregationArray;

public class BaseCustomers extends AgregationArray<Customer> {

	public BaseCustomers() {
		super();
		base = new Customer[0];
	}
	
	public BaseCustomers(Customer[] base) {
		super(base);		
	}
	
	@Override
	public Customer getByID(int id) {
		Customer customer = getTypeByID(id);
		return new Customer(customer.getId(), customer.getSurname(), customer.getName(), customer.getFathers_name(), customer.getAdress(),
				customer.getNumber_card(), customer.getNumber_account());
	}
	
	public void showSortAllCustomers() {
		if (base.length == 0) {
			System.out.println("База пуста!");
			return;
		}

		Customer[] sort_customers = Arrays.copyOf(base, base.length);
		int i = 0;
		while (i < sort_customers.length - 1) {
			if (sort_customers[i].getSurname().compareTo(sort_customers[i + 1].getSurname()) > 0) {
				Customer temp = sort_customers[i];
				sort_customers[i] = sort_customers[i + 1];
				sort_customers[i + 1] = temp;

				if (i != 0) {
					i--;
				}
			} else {
				i++;
			}
		}
		System.out.println("Список всех покупателей в алфовитном порядке по фамилии:\n{");
		for (Customer customer : sort_customers) {
			System.out.println(customer);
		}
		System.out.println("}");
	}

	public void showCustomersWithCardRange(long first, long last) {

		if (base.length == 0) {
			System.out.println("База пуста!");
			return;
		}
		System.out.printf("Список всех покупателей у которых номер карты находится в пределах от %d до %d:\n{\n", first,
				last);
		for (Customer customer : base) {
			if (customer.getNumber_card() >= first && customer.getNumber_card() <= last) {
				System.out.println(customer);
			}
		}
		System.out.println("}\n");

	}
}

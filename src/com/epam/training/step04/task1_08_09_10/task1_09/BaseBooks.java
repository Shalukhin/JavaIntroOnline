/*9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и 
метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и 
методами. Задать критерии выбора данных и вывести эти данные на консоль.
Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.  
Найти и вывести:  
a) список книг заданного автора;  
b) список книг, выпущенных заданным издательством;  
c) список книг, выпущенных после заданного года.*/

package com.epam.training.step04.task1_08_09_10.task1_09;

import com.epam.training.step04.task1_08_09_10.AgregationArray;

public class BaseBooks extends AgregationArray<Book> {

	public BaseBooks() {
		super();
		base = new Book[0];
	}

	public BaseBooks(Book[] base) {
		super(base);		
	}

	@Override
	public Book getByID(int id) {		
		Book book = getTypeByID(id);
		
		return new Book(book.getId(), book.getName(), book.getAuthor(), book.getManufacture(), 
				book.getYear(), book.getCount_pages(), book.getPrice(), book.getHardcover());		
	}
	
	public void showBooksByAuthor(String author) {
		if (base.length == 0) {
			System.out.println("База пуста!");
			return;
		}
		System.out.printf("Список всех книг, автор которых - %s:\n{\n", author);
		for (Book book : base) {
			if (book.getAuthor().equals(author)) {
				System.out.println(book);
			}
		}
		System.out.println("}\n");
	}
	
	public void showBooksByPublishHouse(String manufacture) {
		if (base.length == 0) {
			System.out.println("База пуста!");
			return;
		}
		System.out.printf("Список всех книг, напечатанных издательством \"%s\":\n{\n", manufacture);
		for (Book book : base) {
			if (book.getManufacture().equals(manufacture)) {
				System.out.println(book);
			}
		}
		System.out.println("}\n");

	}
	
	public void showBooksAfterYear(int year) {
		if (base.length == 0) {
			System.out.println("База пуста!");
			return;
		}
		System.out.printf("Список всех книг, изданных после %d года:\n{\n", year);
		for (Book book : base) {
			if (book.getYear() > year) {
				System.out.println(book);
			}
		}
		System.out.println("}\n");

	}

}

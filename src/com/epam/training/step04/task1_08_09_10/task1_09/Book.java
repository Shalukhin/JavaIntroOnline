/*9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и 
метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и 
методами. Задать критерии выбора данных и вывести эти данные на консоль.
Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.  
Найти и вывести:  
a) список книг заданного автора;  
b) список книг, выпущенных заданным издательством;  
c) список книг, выпущенных после заданного года.*/

package step04.task1_08_09_10.task1_09;

import step04.task1_08_09_10.Entity;

public class Book extends Entity {
	
	private String name;
	private String author;
	private String manufacture;
	private int year;
	private int count_pages;
	private int price;
	private String hardcover;
	
	public Book() {
		super();
	}

	public Book(int id, String name, String author, String manufacture, int year, int count_pages, int price,
			String hardcover) {
		super();
		setId(id);
		this.name = name;
		this.author = author;
		this.manufacture = manufacture;
		this.year = year;
		this.count_pages = count_pages;
		this.price = price;
		this.hardcover = hardcover;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCount_pages() {
		return count_pages;
	}

	public void setCount_pages(int count_pages) {
		this.count_pages = count_pages;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getHardcover() {
		return hardcover;
	}

	public void setHardcover(String hardcover) {
		this.hardcover = hardcover;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Книга id = %d:\n\tНазвание       :  %s\n\tАвтор          :  %s\n\tИздательство   :  %s\n\tГод издания    :  %d\n\t"
						+ "Кол-во страниц :  %d\n\tЦена           :  %d\n\tТип переплёта  :  %s\n",
				getId(), name, author, manufacture, year, count_pages, price, hardcover);
	}

}

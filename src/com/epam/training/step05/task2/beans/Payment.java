package step05.task2.beans;

import java.util.Arrays;

public class Payment {
	
	private String id; 
	private long priceTotal = 0;
	private Product[] products = new Product[0];
	
	public class Product {
		String name;
		long price;
		
		public Product(String name, long price) {
			super();
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getPrice() {
			return price;
		}

		public void setPrice(long price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Product [name=" + name + ", price=" + price + "]";
		}
		
	}

		
	public Payment(String id) {
		super();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(long priceTotal) {
		this.priceTotal = priceTotal;
	}

	public Product[] getProducts() {
		return products;
	}
		
	public void setProducts(Product[] products) {
		this.products = products;
	}

	public void setProducts(Product product, int index) {
		
		if (index >= products.length) {
			products = Arrays.copyOf(products, products.length + 1);
			products[products.length - 1] = product;
			return;
		}
		products[index] = product;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", priceTotal=" + priceTotal + ", products=" + Arrays.toString(products) + "]";
	}
	
}

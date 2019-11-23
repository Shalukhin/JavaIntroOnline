package com.epam.training.step05.task5.variant_b.beans.sweets;

public abstract class Sweet {
	
	private String type;
	private long price;
	
	public Sweet(String type) {
		super();
		this.type = type;
		price = 5;
	}

	public Sweet(String type, long price) {
		super();
		this.type = type;
		this.price = price;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sweet other = (Sweet) obj;
		if (price != other.price)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sweet [type=" + type + ", price=" + price + "]";
	}
	
}

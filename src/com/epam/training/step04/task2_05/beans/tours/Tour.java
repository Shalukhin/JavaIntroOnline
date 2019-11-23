package step04.task2_05.beans.tours;

public abstract class Tour {

	protected String type;
	
	private String id;
		
	private int days;
	private String transportation;
	private boolean food;
	private int price;
	
	public Tour() {
		super();		
	}
	
	public Tour(String id, int days, String transportation, boolean food, int price) {
		super();
		this.id = id;
		this.days = days;
		this.transportation = transportation;
		this.food = food;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getDays() {
		return days;
	}
	
	public void setDays(int days) {
		this.days = days;
	}
	
	public String getTransportation() {
		return transportation;
	}
	
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	
	public boolean isFood() {
		return food;
	}
	
	public void setFood(boolean food) {
		this.food = food;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String receiveSpecificInfo() {
		return "Специфической информации нет";
	}

	@Override
	public String toString() {
		return "Tour [days=" + days + ", transportation=" + transportation + ", food=" + food + ", price=" + price
				+ "]";
	}
}
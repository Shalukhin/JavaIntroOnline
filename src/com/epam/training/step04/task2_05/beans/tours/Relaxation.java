package step04.task2_05.beans.tours;

public class Relaxation extends Tour {
	
	private String country = "страна не задана";

	public Relaxation() {
		super();
	}

	public Relaxation(String id, int days, String transportation, boolean food, int price) {
		super(id, days, transportation, food, price);
		type = this.getClass().getSimpleName();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String receiveSpecificInfo() {		
		return String.format("Страна отдыха - %s", country);
	}

	@Override
	public String toString() {
		return "Relaxation [country=" + country + "]";
	}
}

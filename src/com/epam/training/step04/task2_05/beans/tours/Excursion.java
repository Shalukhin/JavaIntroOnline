package step04.task2_05.beans.tours;

public class Excursion extends Tour {
	
	String country = "страна не задана";
	String guide_language = "язык не задан";
	
	public Excursion() {
		super();		
	}
	
	public Excursion(String id, int days, String transportation, boolean food, int price) {
		super(id, days, transportation, food, price);
		type = this.getClass().getSimpleName();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGuide_language() {
		return guide_language;
	}

	public void setGuide_language(String guide_language) {
		this.guide_language = guide_language;
	}
	
	public String receiveSpecificInfo() {		
		return String.format("Экскурсия будет проходить в стране %s, язык гида - %s", country, guide_language);
	}

	@Override
	public String toString() {
		return "Excursion [country=" + country + ", guide_language=" + guide_language + "]";
	}
	
	
	
	

}

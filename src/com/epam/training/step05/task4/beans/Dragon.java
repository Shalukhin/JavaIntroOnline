package step05.task4.beans;

public class Dragon {
	
	private String name;
	private Cave cave;
	
	
	public Dragon() {
		super();
		name = "Anonimus";
		cave = new Cave();
	}

	public Dragon(String name, Cave cave) {
		super();
		this.name = name;
		this.cave = cave;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	@Override
	public String toString() {
		return "Dragon [name=" + name + ", cave=" + cave + "]";
	}
	
}

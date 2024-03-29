package com.epam.training.step04.task2_05.beans;

public class Client {
	
	private String name;
	private String id;
	
	public Client() {
		super();
	}
	
	public Client(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;		
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("Клиент: имя - %s; id - %s", name, id);
	}
}

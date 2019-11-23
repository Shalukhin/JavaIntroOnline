package com.epam.training.step05.task1.beans;

public class TextFile extends File {
	
	private String text = "";

	public TextFile() {
		super();
	}

	public TextFile(String name, Directory directory) {
		super(name, directory);
	}

	public TextFile(String name, Directory directory, String text) {
		this(name, directory);
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	

}

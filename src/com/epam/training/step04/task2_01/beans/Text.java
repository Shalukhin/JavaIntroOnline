package com.epam.training.step04.task2_01.beans;

public class Text {
	
	private String txtText = "";
	private String title = "";	

	public Text(String title) {
		super();
		this.title = title;
	}
	
	public Text(Word title) {
		super();
		this.title = title.getTxtWord();
	}
	
	public Text(Sentence title) {
		super();
		this.title = title.toString();
	}
	
	public String getTxtText() {
		return txtText;
	}

	public void setTxtText(String txtText) {
		this.txtText = txtText;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Text [txtText=" + txtText + ", title=" + title + "]";
	}
}

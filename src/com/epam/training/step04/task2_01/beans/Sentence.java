package step04.task2_01.beans;

import step04.task2_01.view.Viewer;

public class Sentence {
	
	private String txtSent;
	private Viewer viewer = new Viewer();

	public Sentence() {
		super();		
	}

	public Sentence(String txtSent) {
		super();
		if (txtSent.trim().matches("[^(\\.|\\!|\\?)]+((\\.|\\!|\\?)|(\\.\\.|\\!\\!|\\?\\?)|(\\.\\.\\.|\\!\\!\\!|\\?\\?\\?))")) {
			this.txtSent = txtSent;
		} else {
			viewer.showMessageInConsole(String.format("В предложении не должно быть \".\" ; \"!\" и \"?\""));
		}		
	}

	public String getTxtSent() {
		return txtSent;
	}

	public void setTxtSent(String txtSent) {
		if (txtSent.trim().matches("[^(\\.|\\!|\\?)]+((\\.|\\!|\\?)|(\\.\\.|\\!\\!|\\?\\?)|(\\.\\.\\.|\\!\\!\\!|\\?\\?\\?))")) {
			this.txtSent = txtSent;
		} else {
			viewer.showMessageInConsole(String.format("В предложении не должно быть двух и более \".\" ; \"!\" и \"?\""));
		}
	}

	@Override
	public String toString() {
		return "Sentence [txtSent=" + txtSent + "]";
	}	
}

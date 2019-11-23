package step04.task2_01.beans;

public class Word {

	private String txtWord;

	public Word() {
		super();
	}

	public Word(String txtWord) {
		super();
		if (txtWord.trim().matches(".*\\\\s.*")) {
			System.out.println("Слово не должно содержать пробелов");
		} else {
			this.txtWord = txtWord;
		}		
	}	

	public String getTxtWord() {
		return txtWord;
	}

	public void setTxtWord(String txtWord) {
		if (txtWord.trim().matches(".*\\\\s.*")) {
			System.out.println("Слово не должно содержать пробелов");
		} else {
			this.txtWord = txtWord;
		}		
	}	
	
	@Override
	public String toString() {
		return "Word [txtWord=" + txtWord + "]";
	}
	
}

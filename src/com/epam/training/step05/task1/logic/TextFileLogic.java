package step05.task1.logic;

import step05.task1.beans.TextFile;

public class TextFileLogic {
		
	public TextFileLogic() {
		super();
	}

	public boolean renameTextFile(TextFile textFile, String newName) {
		if (textFile == null) {
			return false;
		}
		textFile.setName(newName);
		return true;
	}

	public boolean renameTextFile(TextFile textFile, String newName, String newDir) {
		if (textFile == null) {
			return false;
		}
		textFile.setName(newName);
		textFile.getDirectory().setDir(newDir);
		return true;
	}
	
	public boolean addTextToTextFile(TextFile textFile, String text) {
		if (textFile == null) {
			return false;
		}
		String temp = textFile.getText() + text;
		textFile.setText(temp);
		return true;

	}
	
}

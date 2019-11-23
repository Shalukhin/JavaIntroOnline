package step05.task1.logic;

import java.util.Arrays;

import step05.task1.beans.Directory;
import step05.task1.beans.NotePad;
import step05.task1.beans.TextFile;

public class NotePadLogic {
	
	private NotePad notePad;

	public NotePadLogic() {
		super();
	}

	public NotePadLogic(NotePad notePad) {
		super();
		this.notePad = notePad;
	}

	public NotePad getNotePad() {
		return notePad;
	}

	public void setNotePad(NotePad notePad) {
		this.notePad = notePad;
	}
	
	public boolean createNewTextFile(String name, Directory directory) {
		for (TextFile textFile : notePad.getArchiveTextFiles()) {
			if (textFile.getName() == name && textFile.getDirectory().getDir() == directory.getDir()) {
				return false;
			}
		}
		TextFile textFile = new TextFile(name, directory);
		notePad.setArchiveTextFilesByIndex(textFile, notePad.getArchiveTextFiles().length);
		return true;
	}
	
	public TextFile[] findTextFilesByName(String name) {
		TextFile[] result = new TextFile[0];
		for (TextFile textFile : notePad.getArchiveTextFiles()) {
			if (textFile.getName() == name) {
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = textFile;
			}
		}
		return result;
	}
	
	public TextFile[] findAllTextFilesInDerectory(String dir) {
		TextFile[] result = new TextFile[0];
		for (TextFile textFile : notePad.getArchiveTextFiles()) {
			if (textFile.getDirectory().getDir() == dir) {
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = textFile;
			}
		}
		return result;
	}
	
	public TextFile findTextFileByNameInDerectory(String name, String dir) {
		for (TextFile textFile : notePad.getArchiveTextFiles()) {
			if (textFile.getName() == name && textFile.getDirectory().getDir() == dir) {
				return textFile;
			}
		}
		return null;
	}
	
	public boolean deleteTextFile(TextFile textFile) {
		if (textFile == null) {
			return false;
		}
		
		TextFile[] temp = notePad.getArchiveTextFiles();
		
		int startLengh = temp.length;		
		
		boolean flagDelete = false;
		for (int i = 0; i < temp.length - 1; i++) {
			if (textFile == temp[i]) {
				flagDelete = true;
			}
			
			if (flagDelete) {
				temp[i] = temp[i + 1];
			}			
		}
		
		if (textFile == temp[temp.length - 1]) {
			flagDelete = true;
		}
		
		if (flagDelete) {
			temp = Arrays.copyOf(temp, temp.length - 1);
		}
		
		notePad.setArchiveTextFiles(temp);
		
		int endLengh = temp.length;
		
		if (startLengh != endLengh) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteTextFileByNameInDerectory(String name, String dir) {
		TextFile temp = findTextFileByNameInDerectory(name, dir);
		if (temp == null) {
			return false;
		}
		
		return deleteTextFile(temp);
	}
	
	
	
	
	
	

}

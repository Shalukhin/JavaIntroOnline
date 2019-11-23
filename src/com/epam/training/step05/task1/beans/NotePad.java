package com.epam.training.step05.task1.beans;

import java.util.Arrays;

public class NotePad {
	
	private TextFile[] archiveTextFiles = new TextFile[0];

	public NotePad() {
		super();
	}

	public NotePad(TextFile ... archiveTextFiles) {
		super();
		this.archiveTextFiles = archiveTextFiles;
	}

	public TextFile[] getArchiveTextFiles() {
		return archiveTextFiles;
	}

	public void setArchiveTextFiles(TextFile[] archiveTextFiles) {
		this.archiveTextFiles = archiveTextFiles;
	}
	
	public void setArchiveTextFilesByIndex(TextFile textFile, int index) {
		
		if (index >= archiveTextFiles.length) {
			archiveTextFiles = Arrays.copyOf(archiveTextFiles, archiveTextFiles.length + 1);
			archiveTextFiles[archiveTextFiles.length - 1] = textFile;
			return;
		}
		
		archiveTextFiles[index] = textFile;		
	}
	
	
	

}

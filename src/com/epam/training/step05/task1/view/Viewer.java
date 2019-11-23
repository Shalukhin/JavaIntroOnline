package step05.task1.view;

import step05.task1.beans.NotePad;
import step05.task1.beans.TextFile;

public class Viewer {
	
	public static void printToConsoleAllTextFilesFromNotePad(NotePad notePad) {
		if (notePad == null) {
			System.out.println("Ошибка! Записная книжка не найдена!");
			return;
		}
		
		System.out.println("Все текстовые файлы из записной книжки:");
		for (TextFile textFile : notePad.getArchiveTextFiles()) {
			System.out.printf("%s.txt\t\t\t%s\n",textFile.getName(), textFile.getDirectory().getDir());
		}
		System.out.println("----------------------------------------\n");
	}
	
	public static void printToConsoleContentOfTextFile(TextFile textFile) {
		if (textFile == null) {
			System.out.println("Ошибка! Файл не найден!");
			return;
		}
		System.out.printf("Содержимое файла %s/%s.txt :\n", textFile.getDirectory().getDir(), textFile.getName());
		
		System.out.println("<<\n" + textFile.getText() + "\n>>\n");
	}

}

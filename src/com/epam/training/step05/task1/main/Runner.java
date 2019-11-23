/*Задача 1.  
Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать, 
вывести на консоль содержимое, дополнить, удалить. */

package step05.task1.main;

import step05.task1.beans.Directory;
import step05.task1.beans.NotePad;
import step05.task1.beans.TextFile;
import step05.task1.logic.NotePadLogic;
import step05.task1.logic.TextFileLogic;
import step05.task1.view.Viewer;

public class Runner {

	public static void main(String[] args) {
		
		NotePad note = new NotePad();
		
		NotePadLogic noteLogic = new NotePadLogic(note);
		
		noteLogic.createNewTextFile("prog1", new Directory("C:/1"));
		noteLogic.createNewTextFile("prog2", new Directory("C:/1"));
		noteLogic.createNewTextFile("prog2", new Directory("C:/1"));
		noteLogic.createNewTextFile("prog3", new Directory("C:/1"));
		
		Viewer.printToConsoleAllTextFilesFromNotePad(note);
		
		TextFile txt = noteLogic.findTextFileByNameInDerectory("prog1", "C:/1");
				
		TextFileLogic textFileLogic = new TextFileLogic();
		
		textFileLogic.addTextToTextFile(txt, "...program code first script...");
		
		Viewer.printToConsoleContentOfTextFile(txt);
		
		textFileLogic.renameTextFile(txt, "script1");
		
		Viewer.printToConsoleAllTextFilesFromNotePad(note);
		
		noteLogic.deleteTextFileByNameInDerectory("prog2", "C:/1");
		
		Viewer.printToConsoleAllTextFilesFromNotePad(note);
	}

}
